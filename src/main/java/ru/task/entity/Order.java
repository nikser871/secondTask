package main.java.ru.task.entity;

import main.java.ru.task.entity.enums.Priority;

import java.util.List;

public record Order(int order,
                    List<String> products,
                    String fio,
                    String address,
                    String phoneNumber,
                    Priority priority) {
}
