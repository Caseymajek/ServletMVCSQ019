package com.decagon.servletmvcsq019.config;

import lombok.Data;
import lombok.Getter;

@Getter
public class DatabaseConfiguration {
    private final String DB_URL = "jdbc:mysql://localhost:3306/ProductDB";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "090Abc.tee";
}
