package com.nixagh.hms_v1.mapper.user;

import com.nixagh.hms_v1.Common.AbstractMapper;
import com.nixagh.hms_v1.modals.UserModal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMapper extends AbstractMapper<UserModal> {
  @Override
  public List<UserModal> map(ResultSet rs) throws SQLException {
    List<UserModal> lst = new ArrayList<UserModal>();
    while (rs.next()) {
      UserModal user = new UserModal();
      user.setUserId(rs.getInt("userId"));
      user.setUsername(rs.getString("username"));
      user.setPassword(rs.getString("password"));
      user.setIsActive(rs.getInt("active"));
      user.setFirstName(rs.getString("firstName"));
      user.setLastName(rs.getString("lastName"));
      user.setFullName(rs.getString("firstName") + " " + rs.getString("lastName"));
      user.setRole(rs.getString("role"));
      user.setTimestamp(rs.getTimestamp("timestamp"));
      lst.add(user);
    }
    rs.close();
    return lst;
  }
}
