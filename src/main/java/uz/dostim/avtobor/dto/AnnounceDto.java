package uz.dostim.avtobor.dto;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class AnnounceDto {

    @Size(min = 7, max = 13)
    private String phoneNumber;

    private Long carId;

}
