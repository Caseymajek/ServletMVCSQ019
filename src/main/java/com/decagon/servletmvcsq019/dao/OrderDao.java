package com.decagon.servletmvcsq019.dao;

import com.decagon.servletmvcsq019.config.DatabaseConfiguration;
import com.decagon.servletmvcsq019.model.Order;
import com.decagon.servletmvcsq019.service.UserService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.function.Function;
import java.util.logging.Logger;

public class OrderDao {
    private Logger logger = Logger.getGlobal();
    private Connection connection;

    public UserService connect = () -> {
        Class.forName("com.mysql.cj.jdbc.Driver");
        DatabaseConfiguration configuration = new DatabaseConfiguration();
        Properties properties = new Properties();
        properties.setProperty("User", configuration.getDB_URL());
        properties.setProperty("Password", configuration.getDB_PASSWORD());
        if (connection==null|| connection.isClosed()){
            connection = DriverManager.getConnection(configuration.getDB_URL(), configuration.getDB_USER(), configuration.getDB_PASSWORD());
        }
    };


    public Function<Order, Boolean> saveOrder = (order -> {
        try {
            connect.compile();
        } catch (SQLException | ClassNotFoundException e) {
            logger.warning("SQL exception"+e.getMessage());
            throw new RuntimeException(e);
        }
        String query = "INSERT INTO ProductDB.order  (productIds, totalPrice) VALUES (?, ?) ";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, order.getProductIds());
            preparedStatement.setDouble(2, order.getTotalPrice().doubleValue());
            return preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    });

}
