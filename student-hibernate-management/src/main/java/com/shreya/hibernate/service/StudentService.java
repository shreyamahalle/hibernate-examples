package com.shreya.hibernate.service;

import com.shreya.hibernate.exception.StudentNotFoundException;
import com.shreya.hibernate.model.Student;
import com.shreya.hibernate.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        System.out.println("Inside service: " + student);
        return studentRepository.save(student);
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

    public Student updateStudent(int id, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setPercentage(updatedStudent.getPercentage());
        return studentRepository.save(existingStudent);
    }
    public List<Student> findStudentWithPagination(int page, int size) {
        List<Student> students = studentRepository.findStudentWithPagination(page, size);
        System.out.println("retrieved pagination data - " + students);
        return students;
    }
}