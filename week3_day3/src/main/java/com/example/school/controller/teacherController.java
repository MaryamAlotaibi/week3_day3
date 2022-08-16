package com.example.school.controller;

import com.example.school.dto.ApiResponse;
import com.example.school.model.Teacher;
import com.example.school.service.teacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
public class teacherController {
    private final teacherService TeacherService;

    public teacherController(teacherService TeacherService) {
        this.TeacherService = TeacherService;
    }

    @GetMapping("/teacher")
    public ResponseEntity getTeacher() {
        List<Teacher> teacherList = teacherService.getTeacher();
        return ResponseEntity.status(200).body(teacherList);
    }

    @PostMapping("/teacher")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("New Teacher added!", 200));
    }


    @PutMapping("/teacher/{id}")
    public ResponseEntity updateTeacher(@RequestBody @Valid Teacher teacher, @PathVariable Integer id) {
        teacherService.updateTeacher(teacher, id);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher updated!", 200));
    }

    @DeleteMapping("/teacher/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher deleted!", 200));
    }
}
