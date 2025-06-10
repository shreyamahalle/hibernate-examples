package com.shreya.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String course;

    public Student(String shreya, String javaFullStack) {
    }


//    public Student(String name, String course) {
//        this.name = name;
//        this.course = course;
   // }
    // Getters & Setters
}