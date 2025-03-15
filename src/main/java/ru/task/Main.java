package main.java.ru.task;

import main.java.ru.task.util.PropertyUtil;


public class Main {
    public static void main(String[] args) {
        String fileName = PropertyUtil.get("order-file.path");
    }
}