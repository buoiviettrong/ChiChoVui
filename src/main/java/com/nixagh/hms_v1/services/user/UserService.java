package com.nixagh.hms_v1.services.user;


import com.nixagh.hms_v1.mapper.user.UserMapper;
import com.nixagh.hms_v1.modals.UserModal;
import com.nixagh.hms_v1.repositories.UserRepository;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

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
    return userRepository.query(sql)
            .stream()
            .map(UserModal::new)
            .collect(Collectors.toList());
  }
  public int create(@NotNull UserModal user) {
    String sql = """
             INSERT INTO User (username, password, firstName, lastName, role, active)
             VALUES (?, ?, ?, ?, ?, ?) ;
             """;
    return userRepository.insert(sql,
            user.getUsername(), user.getPassword(),user.getFirstName(),user.getLastName(), user.getRole(), user.getIsActive());
  }
}
