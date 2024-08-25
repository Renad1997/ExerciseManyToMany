package com.example.exerciserelationi.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "name should be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotNull(message = "age should be not null")
    private int age;


    @NotEmpty(message = "major should be not empty")
    @Column(columnDefinition = "varchar(10) not null")
    private String major;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;

}
