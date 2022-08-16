package com.example.school.service;

import com.example.school.model.Student;
import com.example.school.repository.studentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class studentService {
    private final studentRepository StudentRepository;

    public studentService(studentRepository StudentRepository, studentRepository studentRepository) {
        this.StudentRepository = studentRepository;
    }

    public static void addStudent(Student student) {
        studentRepository.save(student);
    }

    public static void updateStudent(Student student, Integer id) {
        Student oldStudent=studentRepository.getReferenceById(student.getId());
        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        oldStudent.setMajor(student.getMajor());
        studentRepository.save(oldStudent);
    }

    public static void deleteStudent(Integer id) {
        Student s=studentRepository.getReferenceById(id);
        studentRepository.delete(s);
    }

    public List<Student> getUsers() {
        return studentRepository.findAll();
    }
}
