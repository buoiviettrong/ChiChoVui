package com.nixagh.hms_v1.modals;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.sql.Timestamp;
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
}
