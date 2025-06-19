package com.shreya.hibernate.repository;

import com.shreya.hibernate.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    Student save(Student student);

    List<Student> findAll();

    Optional<Student> findById(int id);

    Student deleteById(int id);

    Student updateStudent(int id);

    Student updateStudent(int id, Student updatedStudent);

    List<Student> findStudentWithPagination(int page, int size);
}
