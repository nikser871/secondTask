package main.java.ru.task.entity.enums;

/**
 * Статус невалидного заказа.
 */
public enum ErrorStatus {
    /**
     * Нет ланных о телефоне
     */
    NO_PHONE_DATA,

    /**
     * Нет данных об адресе
     */
    NO_ADDRESS_DATA,

    /**
     * Невалидный номер телефона
     */
    NOT_VALID_PHONE,

    /**
     * Невалидный адрес доставки
     */
    NOT_VALID_ADDRESS
}
