package com.example.school.controller;

import com.example.school.dto.ApiResponse;
import com.example.school.model.Student;
import com.example.school.service.studentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
public class studentController {
    private final studentService StudentService;

    public studentController(studentService StudentService) {
        this.StudentService = StudentService;
    }

    @GetMapping("/student")
    public ResponseEntity<List> getStudent() {
        List<Student> users=StudentService.getUsers();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("/student")
    public ResponseEntity<ApiResponse> addStudent(@RequestBody @Valid Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(201).body( new ApiResponse("New student added !",201));}


    @PutMapping("/student/{id}")
    public ResponseEntity<ApiResponse> updateStudent(@RequestBody @Valid Student student, @PathVariable Integer id) {
        studentService.updateStudent(student, id);
        return ResponseEntity.status(200).body(new ApiResponse("Student updated!", 200));
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body(new ApiResponse("Student deleted!", 200));
    }
}
