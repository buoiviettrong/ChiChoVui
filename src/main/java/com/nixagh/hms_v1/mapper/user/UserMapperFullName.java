package com.nixagh.hms_v1.mapper.user;

import com.nixagh.hms_v1.Common.AbstractMapper;
import com.nixagh.hms_v1.modals.UserWithFullName;
import lombok.Getter;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
public class UserMapperFullName extends AbstractMapper<UserWithFullName>{
  @Override
  public List<UserWithFullName> map(ResultSet rs) throws SQLException {
    List<UserWithFullName> lst = new ArrayList<UserWithFullName>();
    while (rs.next()) {
      int userId = rs.getInt("userId");
      String fullName = rs.getString("firstName")+ " " + rs.getString("lastName");
      lst.add(new UserWithFullName(userId, fullName));
    }
    return lst;
  }
}
