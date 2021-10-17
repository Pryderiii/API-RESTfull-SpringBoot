package com.projects.BCIprueba.services.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    private static Connection connection = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    static {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:hsqldb:mem:mdb:8001", "test", "123123");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static Statement getStatement() {
        if (connection == null) {
            getConnection();
        }

        if (statement == null) {
            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return statement;
    }

    public static void executeSQL(String sql) {
        if (statement == null) {
            getStatement();
        }

        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuerySQL(String sql) {
        if (connection == null) {
            getConnection();
        }
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static void resultPrint(ResultSet resultSet) {
        try {
            int columnCount = resultSet.getMetaData().getColumnCount();
            String columnValue = null;
            while (resultSet.next()) {
                for (int n = 1; n <= columnCount; n++) {
                    columnValue = resultSet.getString(n);
                    if (n == columnCount) {
                        System.out.println(columnValue);
                    } else {
                        System.out.print(columnValue + "\t");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeDB() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showData(){
        resultPrint(DataBase.executeQuerySQL("Select * from PUBLIC.users"));
    }

    public static void createData() {
        DataBase.executeSQL("CREATE TABLE IF NOT EXISTS PUBLIC.users (id VARCHAR(200), name VARCHAR(20), email VARCHAR(50), password VARCHAR(10), created DATE, modified DATE, lastlogin DATE, token VARCHAR(200), active boolean )");
        DataBase.executeSQL("CREATE TABLE IF NOT EXISTS PUBLIC.phones (phoneid VARCHAR(200), id VARCHAR(200), number VARCHAR(15), citycode VARCHAR(5), countrycode VARCHAR(3))");

        DataBase.executeSQL("INSERT INTO PUBLIC.users VALUES('e381fa66-2f5d-11ec-8d3d-0242ac130003','Pedro Perez', 'p.perezgmail.com', 'a1bA1', current_date, current_date, current_date, 'e381fcb4-2f5d-11ec-8d3d-0242ac130003', 1)");
        DataBase.executeSQL("INSERT INTO PUBLIC.phones VALUES('e381fa66-2f5d-11ec-8d3d-0a42ac130003','e381fa66-2f5d-11ec-8d3d-0242ac130003','1231231','12','56')");
        DataBase.executeSQL("COMMIT");

        DataBase.closeDB();
    }
}