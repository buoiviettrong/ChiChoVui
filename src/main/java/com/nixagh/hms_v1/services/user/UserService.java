package com.nixagh.hms_v1.services.user;

import com.nixagh.hms_v1.Common.utility.RecordStatement;
import com.nixagh.hms_v1.mapper.user.UserMapper;
import com.nixagh.hms_v1.mapper.user.UserMapperFullName;
import com.nixagh.hms_v1.modals.UserModal;
import com.nixagh.hms_v1.modals.UserWithFullName;
import com.nixagh.hms_v1.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
  private final UserRepository userRepository;
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  public List<UserModal> findAll() throws SQLException {
    String sql = """
            SELECT *
            FROM User ;
            """;
    return userRepository.query(sql, new UserMapper());
  }
  public int create(UserModal user) throws SQLException {
    String sql = """
             INSERT INTO User (username, password, firstName, lastName, role, active)
             VALUES (?, ?, ?, ?, ?, ?) ;
             """;
    ArrayList<RecordStatement> recordStatements = new ArrayList<>();
    recordStatements.add(new RecordStatement(1, "STRING", user.getUsername()));
    recordStatements.add(new RecordStatement(2, "STRING", user.getPassword()));
    recordStatements.add(new RecordStatement(3, "STRING", user.getFirstName()));
    recordStatements.add(new RecordStatement(4, "STRING", user.getLastName()));
    recordStatements.add(new RecordStatement(5, "STRING", user.getRole()));
    recordStatements.add(new RecordStatement(6, "INT", user.getIsActive()));

    return userRepository.insert(sql, recordStatements);
  }
  public List<UserWithFullName> findAllWithFullNames() throws SQLException {
    String sql = """
            SELECT *
            FROM User ;
            """;
    return userRepository.query(sql, new UserMapperFullName());
  }
}
