package com.alibou.demo.subject;

import com.alibou.demo.chapter.Chapter;

import java.util.List;

public interface SubjectService {
    Subject saveSubject(Subject subject);

    Subject findSubjectById(int id);

    List<Subject> findAll();

    void deleteById(Integer id);

    void update(Subject subject);

    List<Chapter> getChaptersByCourseId(int id);
}
