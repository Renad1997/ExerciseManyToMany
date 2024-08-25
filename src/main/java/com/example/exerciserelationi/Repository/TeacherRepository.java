package com.example.exerciserelationi.Repository;

import com.example.exerciserelationi.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

 Teacher findTeacherById(Integer id);
}
