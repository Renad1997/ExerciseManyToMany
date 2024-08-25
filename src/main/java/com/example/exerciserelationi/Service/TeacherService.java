package com.example.exerciserelationi.Service;

import com.example.exerciserelationi.Api.ApiException;
import com.example.exerciserelationi.Model.Teacher;
import com.example.exerciserelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;


    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id,Teacher teacher) {
        Teacher teacher1=teacherRepository.findTeacherById(id);
        if(teacher1==null) {
            throw new ApiException("Teacher not found");
        }
        teacher1.setName(teacher.getName());
        teacher1.setAge(teacher.getAge());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setSalary(teacher.getSalary());
        teacherRepository.save(teacher1);
    }

    public void deleteTeacher(Integer id) {
        Teacher teacher1=teacherRepository.findTeacherById(id);
        if(teacher1==null) {
            throw new ApiException("Teacher not found");
        }
        teacherRepository.delete(teacher1);
    }

    public Teacher getTeacherDetails(Integer id) {
        Teacher teacher1=teacherRepository.findTeacherById(id);
        if(teacher1==null) {
            throw new ApiException("Teacher not found");
        }
      return teacher1;
    }



}
