package uz.dostim.avtobor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "model")
public class Model extends BaseEntity{

    @ManyToOne
    private Brand brand;


}
