package com.example.Repository;

import com.example.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Long> {

    @Query("Select s.student_id,s.name,s.dob from student s join student_courses sc on sc.student_id=s.student_id where sc.courses_enrolled =:keyword")
    List<Student> searchByCourse(@Param("keyword") String keyword);

}
