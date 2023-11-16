package com.alibou.demo.subject.impl;

import com.alibou.demo.chapter.Chapter;
import com.alibou.demo.subject.Subject;
import com.alibou.demo.subject.SubjectRepository;
import com.alibou.demo.subject.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject findSubjectById(int id) {
        return subjectRepository.findById(id).get();
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public void update(Subject subject) {
        Subject existSubject = findSubjectById(subject.getId());

        if (existSubject != null){
            existSubject.setName(subject.getName());
            existSubject.setChapters(subject.getChapters());
            existSubject.setStudents(subject.getStudents());

            subjectRepository.save(existSubject);
        }
    }

    @Override
    public List<Chapter> getChaptersByCourseId(int id) {
        Subject subject = findSubjectById(id);
        return subject.getChapters();
    }
}
