package dev.nano.exception;

import dev.nano.exception.domain.notification.FailedSendEmailException;
import dev.nano.exception.domain.notification.NotificationNotFoundException;
import dev.nano.exception.domain.payment.PaymentNotFoundException;
import dev.nano.exception.domain.product.InsufficientProductQuantityException;
import dev.nano.exception.domain.product.ProductNotFoundException;
import dev.nano.exception.util.DateUtil;
import dev.nano.exception.domain.customer.CustomerNotFoundException;
import dev.nano.exception.domain.order.OrderNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import static dev.nano.exception.constant.ExceptionConstant.*;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception exception, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(
                HttpResponse.builder()
                        .reason(exception.getMessage())
                        .status(status)
                        .statusCode(status.value())
                        .timeStamp(LocalDateTime.now().format(DateUtil.dateTimeFormatter()))
                        .build(), status);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<HttpResponse<?>> handleOrderNotFoundException(OrderNotFoundException exception) {
        return createHttpErrorResponse(HttpStatus.NOT_FOUND, ORDER_NOT_FOUND_EXCEPTION_MESSAGE, exception);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<HttpResponse<?>> handleCustomerNotFoundException(CustomerNotFoundException exception) {
        return createHttpErrorResponse(HttpStatus.NOT_FOUND, CUSTOMER_NOT_FOUND_EXCEPTION_MESSAGE, exception);
    }

    @ExceptionHandler(NotificationNotFoundException.class)
    public ResponseEntity<HttpResponse<?>> handleNotificationNotFoundException(NotificationNotFoundException exception) {
        return createHttpErrorResponse(HttpStatus.NOT_FOUND, NOTIFICATION_NOT_FOUND_EXCEPTION_MESSAGE, exception);
    }

    @ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<HttpResponse<?>> handlePaymentNotFoundException(PaymentNotFoundException exception) {
        return createHttpErrorResponse(HttpStatus.NOT_FOUND, PAYMENT_NOT_FOUND_EXCEPTION_MESSAGE, exception);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<HttpResponse<?>> handleProductNotFoundException(ProductNotFoundException exception) {
        return createHttpErrorResponse(HttpStatus.NOT_FOUND, PRODUCT_NOT_FOUND_EXCEPTION_MESSAGE, exception);
    }

    @ExceptionHandler(FailedSendEmailException.class)
    public ResponseEntity<HttpResponse<?>> handleFailedSendEmailException(FailedSendEmailException exception) {
        return createHttpErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, FAILED_SEND_EMAIL_EXCEPTION_MESSAGE, exception);
    }

    @ExceptionHandler(InsufficientProductQuantityException.class)
    public ResponseEntity<HttpResponse<?>> handleInsufficientProductQuantityException(InsufficientProductQuantityException exception) {
        return createHttpErrorResponse(HttpStatus.BAD_REQUEST, INSUFFICIENT_PRODUCT_QUANTITY_EXCEPTION_MESSAGE, exception);
    }


    private ResponseEntity<HttpResponse<?>> createHttpErrorResponse(HttpStatus httpStatus, String reason, Exception exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(
                HttpResponse.builder()
                        .reason(reason)
                        .status(httpStatus)
                        .statusCode(httpStatus.value())
                        .timeStamp(LocalDateTime.now().format(DateUtil.dateTimeFormatter()))
                        .build(), httpStatus);
    }
}
