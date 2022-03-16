package uz.dostim.avtobor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.dostim.avtobor.enums.Color;
import uz.dostim.avtobor.enums.Energy;
import uz.dostim.avtobor.enums.Version;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Brand brand;              // Automobil brendi

    @OneToOne
    private ProfileEntity profile;

    @Column(nullable = false)
    private Integer years;           // Nechanchi yil ishlab chiqarilgani

    @Column(nullable = false)
    private double price;            // Narxi

    @Column(nullable = false)
    private Color color;             //Rangi

    @Column(nullable = false)
    private long walking;           // Qancha masofa yurgani

    @Column(nullable = false)
    private Energy energy;          //Foydalanadigan yoqilg'i yo energiyasi

    private Version version;        //Nechanchi pozitsiyaligi
    private String description;     // Avtomobil haqida qo'shimcha ma'lumot
    private boolean agreement;      // Narxini arzonlashtiradimi
    private boolean isRented;       // Ijaraga beriladimi
    private boolean isAutomatic;    // Uzatmalar qutisi aftomatikmi yoki ruchnoymi

    private LocalDateTime createAt;
    private Date updateAt;



}
