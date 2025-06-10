package com.shreya.hibernate.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String course;

    public Student() {}
    public Student(String name, String course) {
        this.name = name;
        this.course = course;
    }
    // Getters & Setters
}