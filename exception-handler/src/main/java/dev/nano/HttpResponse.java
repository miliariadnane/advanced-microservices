package dev.nano;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static dev.nano.util.DateUtil.dateTimeFormatter;

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

