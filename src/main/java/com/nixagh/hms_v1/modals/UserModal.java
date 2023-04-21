package com.nixagh.hms_v1.modals;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Map;

@Entity
@Table(name = "User")
@Validated
@Getter
@Setter
public class UserModal {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name = "userId")
  private int userId;
  @Column(name = "username")
  private String username;
  @Column(name = "password")
  private String password;
  @Column(name = "firstName")
  private String firstName;
  @Column(name = "lastName")
  private String lastName;
  @Column(name = "fullName")
  private String fullName;
  @Column(name = "role")
  private String role;
  @Column(name = "isActive")
  private int isActive;
  @Column(name = "timestamp")
  private Timestamp timestamp;

  public UserModal(Map<String, Object> params) {
    this.userId = (int) params.get("userId");
    this.username = (String) params.get("username");
    this.password = (String) params.get("password");
    this.firstName = (String) params.get("firstName");
    this.lastName = (String) params.get("lastName");
    this.role = (String) params.get("role");
    this.isActive = (int) params.get("isActive");
    this.timestamp = (Timestamp) params.get("timestamp");
  }
  public UserModal() {}

  @Override
  public String toString() {
    return """
           UserModal:
            userId:  %d
            username: %s
            password: %s
            firstName: %s
            lastName: %s
            fullName: %s
            role: %s
            isActive: %d
            timestamp: %s
           """.formatted(userId, username, password, firstName, lastName, fullName, role, isActive, timestamp.toString());
  }
}
