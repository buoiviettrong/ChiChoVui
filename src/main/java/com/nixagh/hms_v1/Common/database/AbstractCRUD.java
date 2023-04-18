package com.nixagh.hms_v1.Common.database;

import com.nixagh.hms_v1.Common.AbstractMapper;
import com.nixagh.hms_v1.Common.utility.RecordStatement;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public abstract class AbstractCRUD {
  private final DBAStatement statement = new DBAStatement();
  public <T extends AbstractMapper<Z>, Z> List<Z> query(String sql, ArrayList<RecordStatement> params, T mapper) throws SQLException {
    return mapper.map(statement.getStatement(sql, params).executeQuery());
  }
  public <T extends AbstractMapper<Z>, Z> List<Z> query(String sql, T mapper) throws SQLException {
    return mapper.map(statement.getStatement(sql).executeQuery());
  }
  public int insert(String sql, ArrayList<RecordStatement> params) {
    int result = -1;
    try {
      PreparedStatement ps = statement.getStatement(sql, params, Statement.RETURN_GENERATED_KEYS);
      ps.executeUpdate();
      ResultSet rs = ps.getGeneratedKeys();
      if (rs.next()) result = rs.getInt(1);
      ps.close();
      rs.close();
    } catch (SQLException e) {
      result = -1;
    }
    return result;
  }
}
