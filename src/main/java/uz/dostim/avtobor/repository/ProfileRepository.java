package uz.dostim.avtobor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.dostim.avtobor.entity.ProfileEntity;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
}
