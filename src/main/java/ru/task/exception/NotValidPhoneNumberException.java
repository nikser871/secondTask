package main.java.ru.task.exception;

/**
 * Исключение: неправильный формат номера телефона
 */
public class NotValidPhoneNumberException extends RuntimeException {

    public NotValidPhoneNumberException(String message) {
        super(message);
    }
}
