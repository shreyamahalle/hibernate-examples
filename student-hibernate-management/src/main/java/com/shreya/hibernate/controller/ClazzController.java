package com.shreya.hibernate.controller;

import com.shreya.hibernate.model.Clazz;
import com.shreya.hibernate.model.Student;
import com.shreya.hibernate.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clazzManagement")
public class ClazzController {

    @Autowired
    private ClazzService service;

    @PostMapping("/clazz")
    public ResponseEntity<Clazz> createClazz(@RequestBody Clazz clazz) {
        System.out.println("Inside controller: " + clazz);
        return new ResponseEntity(service.createClazz(clazz), HttpStatus.CREATED);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Student> createStudent(@PathVariable("id") int studentId) {
        System.out.println("Inside controller: " + studentId);
        return new ResponseEntity(service.deleteStudent(studentId), HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> retrieveStudent(@PathVariable("id") int studentId) {
        System.out.println("Inside controller: " + studentId);
        return new ResponseEntity(service.retrieveStudent(studentId), HttpStatus.OK);
    }

    @GetMapping("/students")
    public List<Student> retrieveStudent() {
        return service.retrieveStudents();
    }
}