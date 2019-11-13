package com.zero5nelsonm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "zooanimals", uniqueConstraints = {@UniqueConstraint(columnNames = {"zooid", "animalid"})})
public class ZooAnimals {

    @Id
    @ManyToOne
    @JoinColumn(name = "zooid")
    @JsonIgnoreProperties(value = "zooanimals")
    private Zoo zoo;

    @Id
    @ManyToOne
    @JoinColumn(name = "animalid")
    @JsonIgnoreProperties(value = "zooanimals")
    private Animal animal;
}
