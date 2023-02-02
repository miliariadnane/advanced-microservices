package dev.nano;

import dev.nano.domain.order.OrderNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import static dev.nano.constant.ProductExceptionConstant.ACCOUNT_NOT_FOUND_EXCEPTION_MESSAGE;
import static dev.nano.util.DateUtil.dateTimeFormatter;

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
                        .timeStamp(LocalDateTime.now().format(dateTimeFormatter()))
                        .build(), status);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<HttpResponse<?>> handleOrderNotFoundException(OrderNotFoundException exception) {
        return createHttpErrorResponse(HttpStatus.NOT_FOUND, ACCOUNT_NOT_FOUND_EXCEPTION_MESSAGE, exception);
    }


    private ResponseEntity<HttpResponse<?>> createHttpErrorResponse(HttpStatus httpStatus, String reason, Exception exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(
                HttpResponse.builder()
                        .reason(reason)
                        .status(httpStatus)
                        .statusCode(httpStatus.value())
                        .timeStamp(LocalDateTime.now().format(dateTimeFormatter()))
                        .build(), httpStatus);
    }
}
