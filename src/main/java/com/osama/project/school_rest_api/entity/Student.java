package com.osama.project.school_rest_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "school_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "grade")
    private int grade;


}
