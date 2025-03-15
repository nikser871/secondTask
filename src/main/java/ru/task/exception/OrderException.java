package main.java.ru.task.exception;

import main.java.ru.task.entity.enums.ErrorStatus;

/**
 * Исключение: Нет данных
 */
public class OrderException extends RuntimeException {

    private ErrorStatus status;

    public OrderException(String message, ErrorStatus status) {
        super(message);
        this.status = status;
    }

    public ErrorStatus getStatus() {
        return status;
    }
}
