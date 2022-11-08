package com.itProger;

import javax.swing.plaf.SplitPaneUI;
import java.sql.*;

public class DB {

    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DB_NAME = "java_db";
    private final String LOGIN = "root";
    private final String PASSWORD = "root";

    private Connection dbConn = null;

    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        // �������� ������ �����������
        String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        Class.forName("com.mysql.cj.jdbc.Driver");

        // ��������� ����������
        dbConn = DriverManager.getConnection(connStr, LOGIN, PASSWORD);
        return dbConn;
    }

    // �������� �����������
    public void isConnected() throws SQLException, ClassNotFoundException {
        dbConn = getDbConnection();
        System.out.println(dbConn.isValid(1000));
    }

    public void createTable(String tableName) throws SQLException, ClassNotFoundException{
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName
                + " (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), password VARCHAR(100))"
                + " ENGINE = MYISAM;";

        //�������� ������� � ��� ������� �����������
        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate(sql);
    }

    // ���������� ������ � �������
    public void insertArticle(String title, String text, String date, String autor) throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO `articles` (title, text, date, autor) VALUES (?, ?, ?, ?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
        prSt.setString(1, title);
        prSt.setString(2, text);
        prSt.setString(3, date);
        prSt.setString(4, autor);

        prSt.executeUpdate();
    }

    public void getArticles(String table) throws SQLException, ClassNotFoundException {
         //String sql = "SELECT * FROM " + table;
        //String sql = "SELECT `id`, `title`, `text` FROM " + table;
        //String sql = "SELECT * FROM " + table + " WHERE `id` <> 2";
        String sql = "SELECT * FROM " + table + " WHERE `title` LIKE '%Post%' OR `id` < 4";

        //�������� ������� � ��� ������� �����������
        Statement statement = getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.print(resultSet.getString("id") + "\t\t");
            System.out.print(resultSet.getString("title") + "\t\t");
            System.out.print(resultSet.getString("text") + "\t\t");
            System.out.println(resultSet.getString("autor") );
        }
    }

    //���������� ������
    public void updateArticles() throws SQLException, ClassNotFoundException {
        String sql = "UPDATE `articles` SET `title` = ? WHERE `id` = 2";

        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
        prSt.setString(1, "����� ����������� ������");
        prSt.executeUpdate();
    }

    // �������� ������
    public void deleteSomething() throws SQLException, ClassNotFoundException {
        // �������� ���� �������
        //String sql = "DELETE FROM `articles`
        //String sql = "DELETE FROM `articles` WHERE `id` = 4";

        //�������� �������
        String sql = "DROP TABLE `articles`";

        //�������� ������� � ��� ������� �����������
        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate(sql);


    }
}
