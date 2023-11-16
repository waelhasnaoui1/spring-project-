package com.alibou.demo.student;

import java.util.List;

public interface StudentService {

    void saveStudent(Student s);
    Student findStudentById(Integer id);
    List<Student> findAll();
    void deleteById(Integer id);

    void subscribeToSubject(Integer id,Integer subjectId);
}
