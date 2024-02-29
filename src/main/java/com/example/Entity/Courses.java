package com.example.Entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Courses {

    @NotNull
    @Size(max = 100)
    private String courses_enrolled;
}
