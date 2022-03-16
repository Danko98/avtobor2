package uz.dostim.avtobor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.dostim.avtobor.entity.Brand;
import uz.dostim.avtobor.entity.City;

public interface CityRepository extends JpaRepository<City, Long> {
    boolean existsByName(String name);
}
