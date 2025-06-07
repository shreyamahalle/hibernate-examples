package com.shreya.hibernate.service;
import com.shreya.hibernate.exception.StudentNotFoundException;
import com.shreya.hibernate.model.Clazz;
import com.shreya.hibernate.model.Student;
import com.shreya.hibernate.repository.ClazzRepositoryImpl;
import com.shreya.hibernate.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClazzService {

    @Autowired
    private ClazzRepositoryImpl clazzRepository;
    @Autowired
    private StudentRepository studentRepository;

    public Clazz createClazz(Clazz clazz) {
        System.out.println("Inside service: " + clazz);
        return clazzRepository.save(clazz);
    }

    public Student deleteStudent(int id) {
        Student deletedStudent = studentRepository.deleteById(id);
        System.out.println("Deleted student: " + deletedStudent);
        return deletedStudent;
    }

    public Student retrieveStudent(int id) {
        Optional<Student> retrievedStudent = studentRepository.findById(id);
        if (retrievedStudent.isEmpty()) {
            throw new StudentNotFoundException("student not found");
        }
        System.out.println("retrievedStudent : " + retrievedStudent);
        return retrievedStudent.get();
    }

    public List<Student> retrieveStudents() {
        return studentRepository.findAll();
    }
}