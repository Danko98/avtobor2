package uz.dostim.avtobor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.dostim.avtobor.entity.AttachContent;

import java.util.Optional;

public interface AttachContentRepository extends JpaRepository<AttachContent, Long> {
    Optional<AttachContent> findByAttachment_Id(Long attachment_id);
}
