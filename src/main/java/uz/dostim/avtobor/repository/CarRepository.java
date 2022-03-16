package uz.dostim.avtobor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.dostim.avtobor.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
