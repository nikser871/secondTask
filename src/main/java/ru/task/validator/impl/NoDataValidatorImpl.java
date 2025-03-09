package main.java.ru.task.validator.impl;

import main.java.ru.task.entity.Order;
import main.java.ru.task.exception.NoDataException;
import main.java.ru.task.validator.Validator;

import java.util.Objects;
import java.util.function.Predicate;

import static java.util.Objects.nonNull;

/**
 * Реализация валидатора для проверки на отсутствие данных (либо номера телефона, либо адреса)
 */
public class NoDataValidatorImpl implements Validator<Order> {

    Predicate<Order> predicate = order -> nonNull(order.address()) && nonNull(order.phoneNumber());

    @Override
    public boolean isValid(Order order) throws NoDataException {
        if (predicate.test(order))
            return true;
        else
            throw new NoDataException("Отстутствуют данные в заказе!");
    }
}
