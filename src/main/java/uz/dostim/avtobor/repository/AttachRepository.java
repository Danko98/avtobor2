package uz.dostim.avtobor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.dostim.avtobor.entity.Attachment;

import java.util.Optional;

public interface AttachRepository extends JpaRepository<Attachment, Long> {

}
