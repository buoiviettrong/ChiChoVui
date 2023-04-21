package com.nixagh.hms_v1.controllers;

import com.nixagh.hms_v1.modals.UserModal;
import com.nixagh.hms_v1.modals.UserWithFullName;
import com.nixagh.hms_v1.services.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
  private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
  private final UserService userService;
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public List<UserModal> getAllUsers() throws SQLException {
    return userService.findAll();
  }

  @PostMapping
  public int createUser(@RequestBody UserModal user) throws SQLException {
    return userService.create(user);
  }
}
