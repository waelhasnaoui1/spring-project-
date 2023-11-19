package com.alibou.demo.student.impl;

import com.alibou.demo.student.model.dto.StudentResponse;
import com.alibou.demo.student.model.entities.Student;
import com.alibou.demo.student.StudentRepository;
import com.alibou.demo.student.StudentService;
import com.alibou.demo.student.model.mapper.StudentMapper;
import com.alibou.demo.subject.Subject;
import com.alibou.demo.subject.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final SubjectService subjectService;

    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository, SubjectService subjectService, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.subjectService = subjectService;
        this.studentMapper = studentMapper;
    }

    @Override
    public void saveStudent(Student s) {
        this.studentRepository.save(s);
    }

    public StudentResponse findStudentById(Integer id) {
        Student student = this.studentRepository.findById(id).get();
        return studentMapper.toStudentDto(student) ;
    }

    @Override
    public List<StudentResponse> findAll() {

        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toStudentDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        this.studentRepository.deleteById(id);
    }

    @Override
    public void subscribeToSubject(Integer id, Integer subjectId) {
        Student existStudent = this.studentRepository.findById(id).get();
        Subject existSubject = subjectService.findSubjectById(subjectId);

        List<Subject> listSubject = existStudent.getSubjects();

        listSubject.add(existSubject);

        existStudent.setSubjects(listSubject);

        saveStudent(existStudent);

    }

    @Override
    public StudentResponse findStudentByFirstName(String firstName) {
        return null;
    }
}
