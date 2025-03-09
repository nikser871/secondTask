package main.java.ru.task.repository;

import main.java.ru.task.entity.Order;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Репозиторий для работы с заказами
 */
public interface OrderRepository {

    /**
     * Получить список заказов
     *
     * @param inputStream поток на чтение
     * @return список заказов
     */
    List<Order> readOrdersFromInputStream(InputStream inputStream);

    /**
     * Записать в файл список успешных заказов
     *
     * @param outputStream поток на запись
     * @param orders успешные заказы
     */
    void writeSuccessOrdersToOutputStream(OutputStream outputStream, List<Order> orders);

}
