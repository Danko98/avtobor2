package uz.dostim.avtobor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "region")
public class Region extends BaseEntity{



    @OneToMany
    List<City> cityList;

}
