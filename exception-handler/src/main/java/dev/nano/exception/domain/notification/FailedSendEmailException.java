package dev.nano.exception.domain.notification;

public class FailedSendEmailException extends RuntimeException {

    public FailedSendEmailException(String message) {
        super(message);
    }
}
