package uz.dostim.avtobor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "announce")
public class Announce extends BaseEntity{

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne
    private Car car;


    private boolean isActive;
}
