package uz.dostim.avtobor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "category")
public class Category extends BaseEntity{

    @Lazy
    @ManyToOne
    private SupCategory supCategory;

    @OneToMany
    private List<Announce> announceList;
}
