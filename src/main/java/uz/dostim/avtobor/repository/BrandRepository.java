package uz.dostim.avtobor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.dostim.avtobor.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
