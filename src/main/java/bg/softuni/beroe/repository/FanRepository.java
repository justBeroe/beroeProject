package bg.softuni.beroe.repository;

import bg.softuni.beroe.model.entity.FanEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface FanRepository extends JpaRepository<FanEntity, Long> {

    List<FanEntity> findByUserUsername(String username);

    @Modifying
    @Transactional
    @Query("UPDATE FanEntity f SET f.price = :price WHERE f.id = :id")
    void updatePriceById(@Param("id") Long id, @Param("price") Integer price);

}
