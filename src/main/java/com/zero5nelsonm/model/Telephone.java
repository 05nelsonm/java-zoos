package com.zero5nelsonm.model;

import javax.persistence.*;

@Entity
@Table(name = "telephones")
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long phoneid;

    private String phonetype;

    @Column(nullable = false, unique = true)
    private String phonenumber;
}
