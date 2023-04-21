package com.nixagh.hms_v1.Common.database;

import com.nixagh.hms_v1.Common.utility.RecordStatement;

import java.sql.*;
import java.util.ArrayList;

public class DBAStatement {
  private final Connection connection;
  public DBAStatement() {
    this.connection = DBAccessor.getInstance();
  }
  public PreparedStatement getStatement(String sql) throws SQLException {
    return connection.prepareStatement(sql);
  }
  public PreparedStatement getStatement(String sql, int statement) throws SQLException {
    return connection.prepareStatement(sql, statement);
  }
  public PreparedStatement getStatement(String sql, Object ...params) throws SQLException {
    return setStatement(connection.prepareStatement(sql), params);
  }
  public PreparedStatement getStatement(String sql,  int statement, Object ...params) throws SQLException {
    return setStatement(connection.prepareStatement(sql, statement), params);
  }
  private PreparedStatement setStatement(PreparedStatement ps, Object ...params) throws SQLException {
    int i = 1;
    for(Object item : params) {
      System.out.println(item.getClass());
      switch (item.getClass().toString()) {
        case "class java.lang.Integer":
          ps.setInt(i++, (Integer) item);
          break;
        case "class java.lang.Long":
          ps.setLong(i++, (Long) item);
          break;
        case "class java.lang.Float":
          ps.setFloat(i++, (Float) item);
          break;
        case "class java.lang.Double":
          ps.setDouble(i++, (Double) item);
          break;
        case "class java.lang.Boolean":
          ps.setBoolean(i++, (Boolean) item);
          break;
        case "class java.lang.String":
          ps.setString(i++, (String) item);
          break;
        case "class java.lang.Date":
          ps.setDate(i++, (Date) item);
        default:
          throw new IllegalStateException("Unexpected value: " + item.getClass());
      }
    }
    return ps;
  }
}