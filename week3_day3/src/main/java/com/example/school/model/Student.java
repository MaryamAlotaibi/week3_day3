package com.example.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Student {
    @NotNull(message = "id should not be null")
    @Id
    private Integer id;

    @NotEmpty(message = "name should not be null")
    private String name;

    @NotEmpty(message = "age should not be null")
    private String age;

    @NotEmpty(message = "major should not be null")
    @Column(columnDefinition = "varchar(10) check (major='CS' or major='MATH' or major='Engineer' )")
    private String major;
}


