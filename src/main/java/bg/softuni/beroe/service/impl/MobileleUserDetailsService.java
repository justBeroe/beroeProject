package bg.softuni.beroe.service.impl;

import bg.softuni.beroe.model.entity.UserRoleEntity;
import bg.softuni.beroe.model.enums.UserRoleEnum;
import bg.softuni.beroe.model.user.MobileleUserDetails;
import bg.softuni.beroe.model.entity.UserEntity;
import bg.softuni.beroe.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MobileleUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  public MobileleUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {

    UserDetails userDetails = userRepository
            .findByUsername(username)
            .map(MobileleUserDetailsService::map)
            //OR userEntity -> map(userEntity)
            .orElseThrow(
                    () -> new UsernameNotFoundException("User with username " + username + " not found!"));
    return userDetails;
  }

  private static UserDetails map(UserEntity userEntity) {

    return new MobileleUserDetails(
        userEntity.getUsername(),
        userEntity.getPassword(),
        userEntity.getRoles().stream().map(UserRoleEntity::getRole).map(MobileleUserDetailsService::map).toList(),
        userEntity.getFirstName(),
        userEntity.getLastName()
    );
  }

  private static GrantedAuthority map(UserRoleEnum role) {
    return new SimpleGrantedAuthority(
        "ROLE_" + role
    );
  }
}
