package com.example.exerciserelationi.Controller;

import com.example.exerciserelationi.Model.Course;
import com.example.exerciserelationi.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getAllCourses() {
        return ResponseEntity.status(200).body(courseService.getAllCourses());
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course) {
        courseService.addCourse(course);
        return ResponseEntity.status(200).body("course added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id,@Valid @RequestBody Course course) {
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body("course updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("course deleted");
    }

       @PutMapping("/{teacher_id}/assign/{course_id}")
    public ResponseEntity assignTeacherToCourse(@PathVariable Integer teacher_id ,@PathVariable Integer course_id){
        courseService.assignTeacherToCourse(course_id, teacher_id);
        return ResponseEntity.status(200).body("assign");
    }

    @GetMapping("/get/{course_id}")
    public ResponseEntity getTeacherNameForClass(@PathVariable Integer course_id){
       return ResponseEntity.status(200).body(courseService.getTeacherNameForClass(course_id));
    }




}
