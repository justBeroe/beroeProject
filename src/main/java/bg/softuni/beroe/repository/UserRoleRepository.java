package bg.softuni.beroe.repository;

import bg.softuni.beroe.model.entity.UserEntity;
import bg.softuni.beroe.model.entity.UserRoleEntity;
import bg.softuni.beroe.model.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
   // Optional<UserRoleEntity> findByRole(UserRoleEnum role);
    UserRoleEntity findByRole(UserRoleEnum role);
}