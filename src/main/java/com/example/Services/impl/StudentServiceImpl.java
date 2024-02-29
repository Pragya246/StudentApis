package com.example.Services.impl;

import com.example.Entity.Student;
import com.example.Exception.ResourceNotFoundException.ResourceNotFoundException;
import com.example.Repository.StudentRepo;
import com.example.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;



    @Override
    public Student addStudent(Student student) {
        Student addedStudent = this.studentRepo.save(student);
        return student;
    }

    @Override
    public List<Student> getStudentList() {
        List<Student> students = studentRepo.findAll();
        return students;
    }

    @Override
    public Student getStudentById(Long id) {
        Student student = studentRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("student",id));
        return student;

    }

    @Override
    public Student updateStudentById(Long id, Student student) {
        Student updatedstudent = studentRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("student",id));
        updatedstudent.setName(student.getName());
        updatedstudent.setCourses(student.getCourses());
        updatedstudent.setDob(student.getDob());
        studentRepo.save(updatedstudent);
        return updatedstudent;
    }

    @Override
    public void deleteStudentById(Long id) {

        Student student = studentRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("student",id));
        studentRepo.delete(student);

    }

    @Override
    public List<Student> getStudentByCourseCode(String courseCode) {
        List<Student> students = studentRepo.searchByCourse("%"+courseCode+"%");;
//        List<Student> studentList = new ArrayList<>();
//        List<Student> studentList = students.stream().map(student -> (student.getCourses().contains(courseCode))?).collect(Collectors.toList());
//        students.forEach(student -> (student.getCourses().contains(courseCode))?studentList.add(student):);
        return students;
    }
}
