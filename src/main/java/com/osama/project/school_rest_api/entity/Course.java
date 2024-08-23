package com.osama.project.school_rest_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "school_course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "course_name")
    private String courseName;


}
