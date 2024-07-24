package bg.softuni.beroe.repository;

import bg.softuni.beroe.model.entity.UserEntity;
import bg.softuni.beroe.model.entity.UserRoleEntity;
import bg.softuni.beroe.model.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
   // Optional<UserRoleEntity> findByRole(UserRoleEnum role);
    UserRoleEntity findByRole(UserRoleEnum role);

//    @Modifying
//    @Query("DELETE FROM UserEntity u WHERE :role MEMBER OF u.id")
//    void removeRoleFromUsers(@Param("id") Long id);
}