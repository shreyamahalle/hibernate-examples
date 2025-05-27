package com.shreya.practice.controller;

import com.shreya.practice.model.Student;
import com.shreya.practice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/studentManagement")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        System.out.println("Inside controller " + student);
        Student saveStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(saveStudent);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Student> deleteStudentById(@PathVariable int id) {
        Student deletedStudent = studentService.deleteStudentById(id);
        return (deletedStudent != null) ? ResponseEntity.ok(deletedStudent) : ResponseEntity.notFound().build();
    }

}
