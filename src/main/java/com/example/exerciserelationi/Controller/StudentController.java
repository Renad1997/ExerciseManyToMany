package com.example.exerciserelationi.Controller;

import com.example.exerciserelationi.Model.Course;
import com.example.exerciserelationi.Model.Student;
import com.example.exerciserelationi.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAllStudents() {
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("student added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id,@Valid @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body("student updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("student deleted");
    }

    @PutMapping("/{student_Id}/assign/{course_Id}")
    public ResponseEntity assignStudentAndCourse(@PathVariable Integer student_Id, @PathVariable Integer course_Id) {
        studentService.assignStudentAndCourse(student_Id, course_Id);
        return ResponseEntity.status(200).body("assign done");
    }
    @PutMapping("/{student_Id}/update/{major}")
    public ResponseEntity updateStudentMajor(@PathVariable Integer student_Id, @PathVariable String major) {
        studentService.updateStudentMajor(student_Id, major);
        return ResponseEntity.status(200).body("Major updated");
    }

    @GetMapping("/get/student/{course_id}")
    public ResponseEntity getStudentList(@PathVariable Integer course_id) {
    return ResponseEntity.status(200).body(studentService.getStudentList(course_id));
    }



}
