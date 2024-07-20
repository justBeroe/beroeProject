package bg.softuni.beroe.model.dto;

import bg.softuni.beroe.model.entity.UserRoleEntity;
import bg.softuni.beroe.model.enums.UserRoleEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class UserRegistrationDTO {
  @NotEmpty
  @Size(min = 5, max = 20)
  private String firstName;
  @NotEmpty
  @Size(min = 5, max = 20)
  private String lastName;
  @NotEmpty
  private String password;
  @NotEmpty
  //@Email
  private String username;

//  private List<UserRoleEntity> roles;
//
//  public List<UserRoleEntity> getRoles() {
//    return roles;
//  }
//
//  public UserRegistrationDTO setRoles(List<UserRoleEntity> roles) {
//    this.roles = roles;
//    return this;
//  }


/// Enum test ///

  private UserRoleEnum role;

  public UserRoleEnum getRole() {
    return role;
  }

  public UserRegistrationDTO setRole(UserRoleEnum role) {
    this.role = role;
    return this;
  }
////


  public String getFirstName() {
    return firstName;
  }

  public UserRegistrationDTO setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public UserRegistrationDTO setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public UserRegistrationDTO setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public UserRegistrationDTO setUsername(String username) {
    this.username = username;
    return this;
  }

  @Override
  public String toString() {
    return "UserRegistrationDTO{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", password='" + (password == null ? "N/A" : "[PROVIDED]") + '\'' +
        ", username='" + username + '\'' +
        '}';
  }
}
