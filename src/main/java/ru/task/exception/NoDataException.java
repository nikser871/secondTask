package main.java.ru.task.exception;

/**
 * Исключение: Нет данных
 */
public class NoDataException extends RuntimeException {

    public NoDataException(String message) {
        super(message);
    }
}
