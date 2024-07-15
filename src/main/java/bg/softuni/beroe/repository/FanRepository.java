package bg.softuni.beroe.repository;

import bg.softuni.beroe.model.entity.FanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FanRepository extends JpaRepository<FanEntity, Long> {
}
