package com.example.exerciserelationi.Service;

import com.example.exerciserelationi.Api.ApiException;
import com.example.exerciserelationi.Model.Course;
import com.example.exerciserelationi.Model.Student;
import com.example.exerciserelationi.Repository.CourseRepository;
import com.example.exerciserelationi.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Integer id,Student student) {
        Student student1=studentRepository.findStudentById(id);
        if(student1==null) {
            throw new ApiException("student not found");
        }
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setMajor(student.getMajor());
       studentRepository.save(student1);
    }

    public void deleteStudent(Integer id) {
        Student student1=studentRepository.findStudentById(id);
        if(student1==null) {
            throw new ApiException("student not found");
        }
        studentRepository.delete(student1);
    }

    public void assignStudentAndCourse(Integer student_id,Integer course_id) {
        Student student1=studentRepository.findStudentById(student_id);
        Course course1=courseRepository.findCourseById(course_id);
        if(student1==null || course1==null) {
            throw new ApiException("can not assign");
        }
        student1.getCourses().add(course1);
        course1.getStudents().add(student1);
        studentRepository.save(student1);
        courseRepository.save(course1);
    }

    public void updateStudentMajor(Integer student_id,String major) {
        Student student1=studentRepository.findStudentById(student_id);
        if(student1==null) {
            throw new ApiException("student not found");
        }
        student1.setMajor(major);
        student1.getCourses().clear();
        studentRepository.save(student1);


//        for(Course course:student1.getCourses()) {
//            course.getStudents().remove(student1);
//        }
    }

    public Set<Student> getStudentList(Integer course_id) {
       Course course1=courseRepository.findCourseById(course_id);
       if(course1==null) {
           throw new ApiException("course not found");
       }
       return course1.getStudents();
    }



}
