package com.alibou.demo.subject;

import com.alibou.demo.chapter.model.entities.Chapter;
import com.alibou.demo.subject.model.dto.SubjectResponse;
import com.alibou.demo.subject.model.entities.Subject;

import java.util.List;

public interface SubjectService {
    SubjectResponse saveSubject(Subject subject);

    SubjectResponse findSubjectById(int id);

    List<SubjectResponse> findAll();

    void deleteById(Integer id);

    void update(Subject subject);

    List<Chapter> getChaptersByCourseId(int id);
}
