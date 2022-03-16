package uz.dostim.avtobor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.dostim.avtobor.entity.Brand;
import uz.dostim.avtobor.entity.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
