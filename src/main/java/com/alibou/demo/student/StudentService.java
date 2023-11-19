package com.alibou.demo.student;

import com.alibou.demo.student.model.dto.StudentResponse;
import com.alibou.demo.student.model.entities.Student;

import java.util.List;

public interface StudentService {

    void saveStudent(Student s);
    StudentResponse findStudentById(Integer id);
    List<StudentResponse> findAll();
    void deleteById(Integer id);

    void subscribeToSubject(Integer id,Integer subjectId);

    StudentResponse findStudentByFirstName(String firstName);
}
