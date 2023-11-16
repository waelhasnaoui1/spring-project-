package com.alibou.demo.student.impl;

import com.alibou.demo.student.Student;
import com.alibou.demo.student.StudentRepository;
import com.alibou.demo.student.StudentService;
import com.alibou.demo.subject.Subject;
import com.alibou.demo.subject.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final SubjectService subjectService;
    public StudentServiceImpl(StudentRepository studentRepository, SubjectService subjectService) {
        this.studentRepository = studentRepository;
        this.subjectService = subjectService;
    }

    @Override
    public void saveStudent(Student s) {
        this.studentRepository.save(s);
    }

    public Student findStudentById(Integer id) {
        return this.studentRepository.findById(id)
                .orElse(null);
    }

    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        this.studentRepository.deleteById(id);
    }

    @Override
    public void subscribeToSubject(Integer id, Integer subjectId) {
        Student existStudent = findStudentById(id);
        Subject existSubject = subjectService.findSubjectById(subjectId);

        List<Subject> listSubject = existStudent.getSubjects();

        listSubject.add(existSubject);

        existStudent.setSubjects(listSubject);

        saveStudent(existStudent);

    }
}
