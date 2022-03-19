package uz.dostim.avtobor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "attach")
public class Attachment{

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "file_original_name",nullable = false)
    private String fileOriginalName;

    @Column(name = "size",nullable = false)
    private long size;

    @Column(name = "content_type",nullable = false)
    private String contentType;

    @Column(name = "created_date",nullable = false)
    private LocalDateTime createdDate = LocalDateTime.now();


}
