package com.shreya.hibernate;

import com.shreya.hibernate.model.Student;
import com.shreya.hibernate.repository.StudentRepository;

import javax.transaction.SystemException;

public class MainApp {
    public static void main(String[] args) throws SystemException {
        Student student = new Student("Shreya", "Java Full Stack");
        StudentRepository dao = new StudentRepository();
        dao.saveStudent(student);
        System.out.println("Student saved successfully!");
    }
}
