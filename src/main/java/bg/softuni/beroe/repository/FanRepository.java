package bg.softuni.beroe.repository;

import bg.softuni.beroe.model.entity.FanEntity;
import bg.softuni.beroe.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FanRepository extends JpaRepository<FanEntity, Long> {

    List<FanEntity> findByUserUsername(String username);

}
