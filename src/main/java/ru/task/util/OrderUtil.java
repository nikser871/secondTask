package main.java.ru.task.util;

import main.java.ru.task.entity.Order;
import main.java.ru.task.entity.enums.ErrorStatus;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Утилитный класс для работы с заказами
 */
public final class OrderUtil {

    private static final String NO_DATA = "no data";

    /**
     * Возвращает строку с подсчитанным количеством продуктов
     *
     * @param products список продуктов
     * @return строка для запись в файл с подсчетом количества
     */
    public static String getProductsWithCounting(List<String> products) {
        Map<String, Integer> map = products.stream()
                .collect(Collectors.groupingBy(name ->
                        name, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));

        StringBuilder result = new StringBuilder();

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            result.append(entry.getKey());
            if (entry.getValue() != 1)
                result.append(" x").append(entry.getValue());
        }

        return result.toString();
    }

    public static String getPresentationOfFailedOrder(Order order, ErrorStatus errorStatus) {
        return switch (errorStatus) {
            case NO_ADDRESS_DATA -> order.order() + ";"
                    + "1;"
                    + NO_DATA;

            case NO_PHONE_DATA -> order.order() + ";"
                    + "2;"
                    + NO_DATA;

            case NOT_VALID_ADDRESS -> order.order() + ";"
                    + "1;"
                    + order.address();

            case NOT_VALID_PHONE -> order.order() + ";"
                    + "2;"
                    + order.phoneNumber();
        };
    }

    public static String getCountryFromOrder(Order order) {
        return order.address().split("\\.")[0];
    }

}
