package uz.dostim.avtobor.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.dostim.avtobor.entity.Announce;
import uz.dostim.avtobor.entity.Brand;

public interface AnnounceRepository extends JpaRepository<Announce, Long> {
    Page<Announce> findAllByActive(boolean active, Pageable pageable);
}
