package com.example.exerciserelationi.Service;

import com.example.exerciserelationi.Api.ApiException;
import com.example.exerciserelationi.Model.Course;
import com.example.exerciserelationi.Model.Teacher;
import com.example.exerciserelationi.Repository.CourseRepository;
import com.example.exerciserelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Integer id,Course course) {
     Course course1=courseRepository.findCourseById(id);
     if(course1==null) {
         throw new ApiException("course not found");
     }
     course1.setName(course.getName());
        courseRepository.save(course1);
    }

    public void deleteCourse(Integer id) {
      Course course1=courseRepository.findCourseById(id);
      if(course1==null) {
          throw new ApiException("course not found");
      }
      courseRepository.delete(course1);
    }

        public void assignTeacherToCourse(Integer course_id ,Integer teacher_id) {
        Course course1=courseRepository.findCourseById(course_id);
        Teacher teacher1=teacherRepository.findTeacherById(teacher_id);

        if(course1==null || teacher1==null) {
            throw new ApiException("can not assign");
        }
        course1.setTeacher(teacher1);
        courseRepository.save(course1);
    }

    public String getTeacherNameForClass(Integer course_id) {
        Course course1=courseRepository.findCourseById(course_id);
        if(course1==null || course1.getTeacher()==null) {
            throw new ApiException("teacher name not found");
        }
        return course1.getTeacher().getName();
    }





}
