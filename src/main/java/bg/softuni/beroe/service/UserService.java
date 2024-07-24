package bg.softuni.beroe.service;

import bg.softuni.beroe.model.dto.UserProfileDto;
import bg.softuni.beroe.model.dto.UserRegistrationDTO;
import bg.softuni.beroe.model.entity.UserEntity;

import java.util.List;

public interface UserService {

  void registerUser(UserRegistrationDTO userRegistration);

  UserProfileDto getProfileData();

  List<UserEntity> findAllUsers();
  void deleteUserById(Long id);


}
