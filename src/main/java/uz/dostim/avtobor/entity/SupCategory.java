package uz.dostim.avtobor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "sup_category")
public class SupCategory extends BaseEntity{

    @OneToMany
    List<Category> categoryList;

}
