package bg.softuni.beroe.service.impl;

import bg.softuni.beroe.model.dto.UserProfileDto;
import bg.softuni.beroe.model.dto.UserRegistrationDTO;
import bg.softuni.beroe.model.entity.UserEntity;
import bg.softuni.beroe.repository.UserRepository;
import bg.softuni.beroe.service.UserHelperService;
import bg.softuni.beroe.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final ModelMapper modelMapper;
  private final PasswordEncoder passwordEncoder;
  private final UserRepository userRepository;
  private final UserHelperService userHelperService;

  public UserServiceImpl(ModelMapper modelMapper,
                         PasswordEncoder passwordEncoder,
                         UserRepository userRepository, UserHelperService userHelperService) {
    this.modelMapper = modelMapper;
    this.passwordEncoder = passwordEncoder;
    this.userRepository = userRepository;
      this.userHelperService = userHelperService;
  }

  @Override
  public void registerUser(UserRegistrationDTO userRegistration) {
    userRepository.save(map(userRegistration));
  }

  private UserEntity map(UserRegistrationDTO userRegistrationDTO) {
    UserEntity mappedEntity = modelMapper.map(userRegistrationDTO, UserEntity.class);

    mappedEntity.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));

    return mappedEntity;
  }

  public UserProfileDto getProfileData() {
    UserEntity user = userHelperService.getUser();

    return modelMapper.map(user, UserProfileDto.class);
  }
}
