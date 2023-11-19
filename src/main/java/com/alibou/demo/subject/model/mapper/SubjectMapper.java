package com.alibou.demo.subject.model.mapper;

import com.alibou.demo.subject.model.dto.SubjectRequest;
import com.alibou.demo.subject.model.dto.SubjectResponse;
import com.alibou.demo.subject.model.entities.Subject;
import org.springframework.stereotype.Service;

@Service
public class SubjectMapper {

    public SubjectResponse toSubjectResponse (Subject subject){
        return SubjectResponse.builder()
                .name(subject.getName())
                .chapters(subject.getChapters())
                .students(subject.getStudents())
                .build();
    }

    public Subject toSubject (SubjectRequest subjectRequest){
        return Subject.builder()
                .id(subjectRequest.getId())
                .name(subjectRequest.getName())
                .chapters(subjectRequest.getChapters())
                .students(subjectRequest.getStudents())
                .build();
    }


}
