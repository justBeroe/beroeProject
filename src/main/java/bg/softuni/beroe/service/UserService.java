package bg.softuni.beroe.service;

import bg.softuni.beroe.model.dto.UserRegistrationDTO;

public interface UserService {

  void registerUser(UserRegistrationDTO userRegistration);

}
