package pl.sda.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_category;

    @Column(name = "CATEGORY")
    private String category;

}
