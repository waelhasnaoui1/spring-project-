package com.alibou.demo.student.model.mapper;

import com.alibou.demo.student.model.dto.StudentRequest;
import com.alibou.demo.student.model.dto.StudentResponse;
import com.alibou.demo.student.model.entities.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public StudentResponse toStudentDto(Student student) {
        return StudentResponse.builder()
                .firstname(student.getFirstname())
                .lastname(student.getLastname())
                .age(student.getAge())
                .nbrSubjects(student.getSubjects().size())
                .build();
    }

    public Student toStudent (StudentRequest studentRequest){
        return Student.builder()
                .id(studentRequest.getId())
                .firstname(studentRequest.getFirstname())
                .lastname(studentRequest.getLastname())
                .age(studentRequest.getAge())
                .build();
    }

}
