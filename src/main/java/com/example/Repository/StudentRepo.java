package com.example.Repository;

import com.example.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Long> {


    @Query("SELECT s FROM Student s JOIN s.courses_enrolled c WHERE c.courses_enrolled = :courseCode")
    List<Student> findByCourseCode(@Param("courseCode") String courseCode);
}
