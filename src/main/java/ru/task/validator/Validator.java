package main.java.ru.task.validator;

/**
 * Интерфейс для проверки объектов типа {@code T}
 *
 * @param <T> тип проверяемого объекта
 */
public interface Validator<T> {

    /**
     * Валидация переданного объекта
     *
     * @param t переданный объект
     * @return true - валидация прошла успешно
     */
    boolean isValid(T t);
}
