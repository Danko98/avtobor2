package uz.dostim.avtobor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.dostim.avtobor.entity.Brand;
import uz.dostim.avtobor.entity.SupCategory;

public interface SupCategoryRepository extends JpaRepository<SupCategory, Long> {
    boolean existsByName(String name);
}
