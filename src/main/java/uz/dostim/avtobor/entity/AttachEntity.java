package uz.dostim.avtobor.entity;

import lombok.Data;
import sun.util.resources.LocaleData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "attach")
public class AttachEntity extends BaseEntity{

    @Column(name = "key")
    private String key;

    @Column(name = "origin_name")
    private String originName;

    @Column(name = "size")
    private Long size;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "extension")
    private String extension;



}
