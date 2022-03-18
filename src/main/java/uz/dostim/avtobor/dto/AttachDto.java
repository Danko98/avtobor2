package uz.dostim.avtobor.dto;

import lombok.Data;


@Data
public class AttachDto {

    private String key;
    private String originName;
    private Long size;
    private String filePath;
    private String extension;
}
