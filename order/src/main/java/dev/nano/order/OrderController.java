package dev.nano.order;

import dev.nano.clients.order.OrderRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = OrderConstant.ORDER_URI_REST_API)
@AllArgsConstructor @Slf4j
@CrossOrigin
public class OrderController {

    private final OrderService orderService;

    @GetMapping(path = "/{orderId}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable("orderId") Long orderId) {
        log.info("Retrieving order with id {}", orderId);
        return new ResponseEntity<>(
            orderService.getOrder(orderId),
            HttpStatus.OK
        );
    }

    @GetMapping(
            produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        log.info("Retrieving all orders");
        return new ResponseEntity<>(
            orderService.getAllOrders(),
            HttpStatus.OK
        );
    }

    @PostMapping(path = "/add")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderRequest orderRequest) {

        return new ResponseEntity<>(
                orderService.createOrder(orderRequest),
                HttpStatus.CREATED
        );
    }
}
