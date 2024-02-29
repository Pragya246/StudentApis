package com.example.Services;

import com.example.Entity.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    List<Student> getStudentList();

    Student getStudentById(Long id);

    Student updateStudentById(Long id, Student student);

    void deleteStudentById(Long id);

//    List<Student> getStudentByCourseCode(String courseCode);


}
