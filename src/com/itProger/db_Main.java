package com.itProger;

import java.sql.SQLException;

public class db_Main {
    public static void main(String[] args) {
        DB db = new DB();
        try {
            //создание соединени€
            //db.isConnected();

            //создание таблицы
            //db.createTable("users");

            //вставка новой строки
            //db.insertArticle("Ќова€ стать€", "“екст статьи ", "2050-12-12", "Admin");

            // создание запроса
            //db.getArticles("articles");

            // обновление данных
            db.updateArticles();

            // удаление данных
            db.deleteSomething();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hello world!");
    }
}