package main.java.ru.task.exception;

/**
 * Исключение: неправильный адрес
 */
public class NotValidAddressException extends RuntimeException {

    public NotValidAddressException(String message) {
        super(message);
    }
}
