package com.nixagh.hms_v1.Common.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DBAccessor {
  private static Connection connection;
//  @Value("${spring.datasource.url}")
  private static String connectionUrl = "jdbc:mysql://localhost:3306/hmsDb?serverTimezone=UTC";
//  @Value("${spring.datasource.username}")
  private static String connectionUsername = "admin";
//  @Value("${spring.datasource.password}")
  private static String connectionPassword = "admin";

  @Value("${spring.datasource.url}")
  private void setConnectionUrl(String url) { connectionUrl = url; }
  @Value("${spring.datasource.username}")
  private void setConnectionUsername(String username) { connectionUsername = username; }
  @Value("${spring.datasource.password}")
  private void setConnectionPassword(String password) { connectionPassword = password; }
  private static Connection connect() {
    try {
      connection = DriverManager.getConnection(connectionUrl, connectionUsername, connectionPassword);
      System.out.println("connect started with connection");
      return connection;
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return null;
  }
  private DBAccessor() {}
  public static Connection getInstance() {
    if (connection == null) {
      connection = connect();
    }
    return connection;
  }
}
