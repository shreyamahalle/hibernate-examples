package com.shreya.hibernate.controller;

import com.shreya.hibernate.model.Student;
import com.shreya.hibernate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/studentManagement")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println("Inside controller: " + student);
        return new ResponseEntity<>(service.createStudent(student), HttpStatus.CREATED);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") int studentId) {
        System.out.println("Inside controller: " + studentId);
        return new ResponseEntity<>(service.deleteStudent(studentId), HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> retrieveStudent(@PathVariable("id") int studentId) {
        System.out.println("Inside controller: " + studentId);
        return new ResponseEntity<>(service.retrieveStudent(studentId), HttpStatus.OK);
    }

    @GetMapping("/students")
    public List<Student> retrieveStudent() {
        return service.retrieveStudents();
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int studentId, @RequestBody Student updatedStudent) {
        System.out.println("Inside controller - Update: " + studentId);
        return new ResponseEntity<>(service.updateStudent(studentId, updatedStudent), HttpStatus.OK);
    }

    @GetMapping("/students/pagination")
    public ResponseEntity<List<Student>> retrieveStudent(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {

        if (page < 1 || size < 1) {
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }

        List<Student> students = service.findStudentWithPagination(page, size);
        return ResponseEntity.ok(students);
    }
}