package com.example.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Teacher {
    @NotNull(message = "id should not be null")
    @Id
    private Integer id;

    @NotEmpty(message = "name should not be null")
    private String name;

    @NotEmpty(message = "Salary should not be null")
    private String salary;
}
