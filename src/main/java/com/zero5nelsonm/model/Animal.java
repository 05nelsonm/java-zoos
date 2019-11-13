package com.zero5nelsonm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animalid;

    @Column(nullable = false, unique = true)
    private String animaltype;

    @OneToMany(mappedBy = "animal",
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "animal")
    private List<ZooAnimals> zooAnimals = new ArrayList<>();
}
