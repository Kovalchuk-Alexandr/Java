package com.itProger;

import java.sql.SQLException;

public class db_Main {
    public static void main(String[] args) {
        DB db = new DB();
        try {
            //�������� ����������
            //db.isConnected();

            //�������� �������
            //db.createTable("users");

            //������� ����� ������
            //db.insertArticle("����� ������", "����� ������ ", "2050-12-12", "Admin");

            // �������� �������
            //db.getArticles("articles");

            // ���������� ������
            db.updateArticles();

            // �������� ������
            db.deleteSomething();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hello world!");
    }
}