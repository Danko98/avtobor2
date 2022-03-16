package uz.dostim.avtobor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.dostim.avtobor.entity.Brand;
import uz.dostim.avtobor.entity.Model;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {

    List<Model> findAllByBrand_Id(Long brand_id);

}
