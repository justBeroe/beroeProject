package bg.softuni.beroe.repository;

import bg.softuni.beroe.model.entity.UserEntity;
import bg.softuni.beroe.model.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  //Optional<UserEntity> findByEmail(String email);
  Optional<UserEntity> findByUsername(String username);
  boolean findByRoles(List<UserRoleEntity> roles);

//  List<UserEntity> findAll();

//  findByUsername(getUserDetails().getUsername())
}
