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
  public PreparedStatement getStatement(String sql, ArrayList<RecordStatement> params) throws SQLException {
    return setStatement(connection.prepareStatement(sql), params);
  }
  public PreparedStatement getStatement(String sql, ArrayList<RecordStatement> params, int statement) throws SQLException {
    return setStatement(connection.prepareStatement(sql, statement), params);
  }
  private PreparedStatement setStatement(PreparedStatement ps, ArrayList<RecordStatement> params) throws SQLException {
    for (RecordStatement item : params) {
      String value = item.value().toString();
      switch (item.type()) {
        case "INT":
          ps.setInt(item.index(), Integer.parseInt(value));
          break;
        case "LONG":
          ps.setLong(item.index(), Long.parseLong(value));
          break;
        case "FLOAT":
          ps.setFloat(item.index(), Float.parseFloat(value));
          break;
        case "DOUBLE":
          ps.setDouble(item.index(), Double.parseDouble(value));
          break;
        case "BOOLEAN":
          ps.setBoolean(item.index(), Boolean.parseBoolean(value));
          break;
        case "STRING":
          ps.setString(item.index(), value);
          break;
        case "DATE":
          ps.setDate(item.index(), Date.valueOf(value));
        default:
          throw new IllegalStateException("Unexpected value: " + item.type());
      }
    }
    return ps;
  }
}