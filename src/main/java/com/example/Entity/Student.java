package com.example.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id;

    private String name;

    private Date dob;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "Student_Courses", joinColumns = @JoinColumn(name = "student_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "courses_enrolled", column = @Column(name = "courses_enrolled"))
    })
    private Set<Courses> courses_enrolled = new HashSet<>();

}
