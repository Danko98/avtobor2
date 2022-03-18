package uz.dostim.avtobor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.dostim.avtobor.entity.Brand;
import uz.dostim.avtobor.entity.City;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    boolean existsByName(String name);
    List<City> findAllByRegion_Id(Long region_id);
}
