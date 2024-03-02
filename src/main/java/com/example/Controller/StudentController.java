package com.example.Controller;

import com.example.Entity.Student;
import com.example.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/api")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add/student")
    ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student student1 = studentService.addStudent(student);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }

    @PutMapping("/update/studentbyid{id}")
    ResponseEntity<Student> updateStudent(@PathVariable Long id , @RequestBody Student student1) {
        Student student = studentService.updateStudentById(id ,student1);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/get/allstudent")
    ResponseEntity<List<Student>> getAllStudent() {
        List<Student> students = studentService.getStudentList();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/get/studentbyid{student_id}")
    ResponseEntity<Student> getStudentById(@PathVariable Long student_id) {
        Student student = studentService.getStudentById(student_id);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/delete/studentbyid{id}")
    ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok("Student deleted successfully.");
    }

    @GetMapping("/findbycourse/{course}")
    ResponseEntity<List<Student>> findStudentsByCourse(@PathVariable String course) {
        List<Student> students = studentService.getStudentByCourseCode(course);
        return ResponseEntity.ok(students);
    }
}
