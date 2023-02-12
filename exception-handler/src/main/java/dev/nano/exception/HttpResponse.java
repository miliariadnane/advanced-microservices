package dev.nano.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@SuperBuilder
@JsonInclude(NON_NULL)
public class HttpResponse<T> {

    private String message;
    private HttpStatus status;
    private int statusCode;
    private String reason;
    protected String timeStamp;
}

