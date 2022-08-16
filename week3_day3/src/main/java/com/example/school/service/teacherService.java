package com.example.school.service;

import com.example.school.model.Teacher;
import com.example.school.repository.teacherRepository;

import java.util.List;

public class teacherService {
    private final teacherRepository TeacherRepository;

    public teacherService(teacherRepository teacherRepository) {
        TeacherRepository = teacherRepository;
    }

    public static List<Teacher> getTeacher() {
        return null;
    }

    public static void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public static void updateTeacher(Teacher teacher, Integer id) {
        Teacher t=teacherRepository.getReferenceById(id);
        t.setName(teacher.getName());
        t.setSalary(teacher.getSalary());
        teacherRepository.save(t);
    }

    public static void deleteTeacher(Integer id) {
        Teacher t=teacherRepository.getReferenceById(id);
        teacherRepository.delete(t);
    }
}
