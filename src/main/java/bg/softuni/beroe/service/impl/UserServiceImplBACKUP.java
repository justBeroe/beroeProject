//package bg.softuni.beroe.service.impl;
//
//import bg.softuni.beroe.model.dto.UserProfileDto;
//import bg.softuni.beroe.model.dto.UserRegistrationDTO;
//import bg.softuni.beroe.model.entity.UserEntity;
//import bg.softuni.beroe.model.entity.UserRoleEntity;
//import bg.softuni.beroe.model.enums.UserRoleEnum;
//import bg.softuni.beroe.repository.UserRepository;
//import bg.softuni.beroe.repository.UserRoleRepository;
//import bg.softuni.beroe.service.UserHelperService;
//import bg.softuni.beroe.service.UserService;
//import jakarta.transaction.Transactional;
//import org.modelmapper.ModelMapper;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Service
//public class UserServiceImplBACKUP implements UserService {
//
//  private final ModelMapper modelMapper;
//  private final PasswordEncoder passwordEncoder;
//  private final UserRepository userRepository;
//  private final UserRoleRepository userRoleRepository;
//  private final UserHelperService userHelperService;
//
//
//
//  public UserServiceImplBACKUP(ModelMapper modelMapper,
//                               PasswordEncoder passwordEncoder,
//                               UserRepository userRepository, UserRoleRepository userRoleRepository, UserHelperService userHelperService) {
//    this.modelMapper = modelMapper;
//    this.passwordEncoder = passwordEncoder;
//    this.userRepository = userRepository;
//      this.userRoleRepository = userRoleRepository;
//      this.userHelperService = userHelperService;
//
//  }
//
//  @Override
//  @Transactional
//  public void registerUser(UserRegistrationDTO userRegistration) {
//    userRepository.save(map(userRegistration));
//  }
//
//
//  private UserEntity map(UserRegistrationDTO userRegistrationDTO) {
//    UserEntity mappedEntity = modelMapper.map(userRegistrationDTO, UserEntity.class);
//
//   // UserRoleEntity userRoleEntity = modelMapper.map(userRegistrationDTO.getRole(), UserRoleEntity.class);
//
//
//
//    List<UserRoleEntity> userRoles = new ArrayList<>();
//      UserRoleEnum roleEnum = userRegistrationDTO.getRole();
//     // UserRoleEntity userRoleEntity2 = mapRoleEnumToEntity(roleEnum);
//     UserRoleEntity userRoleEntity = new UserRoleEntity();
//
//
//    UserRoleEntity userRoleEntity1 = userRoleEntity.setRole(userRegistrationDTO.getRole());
//    userRoles.add(userRoleEntity1);
//
//    mappedEntity.setRoles(userRoles);
//
//    System.out.println(userRoles);
//
////    String listFromDTO = userRegistrationDTO.getRole().toString();
////    UserRoleEnum roleEnum = userRegistrationDTO.getRole();
////
////
////    mappedEntity.setRoles(roleEnum);
//
//    mappedEntity.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
//
//    return mappedEntity;
//  }
//
////    private UserRoleEntity mapRoleEnumToEntity(UserRoleEnum roleEnum) {
////        UserRoleEntity userRoleEntity = userRoleRepository.findByRole(roleEnum);
////        if (userRoleEntity == null) {
////            userRoleEntity = new UserRoleEntity();
//////            userRoleEntity.setRole(roleEnum);
//////            userRoleEntity = userRoleRepository.save(userRoleEntity);
////        }
////        return userRoleEntity;
////    }
//
//  public UserProfileDto getProfileData() {
//    UserEntity user = userHelperService.getUser();
//
//    return modelMapper.map(user, UserProfileDto.class);
//  }
//}
