package com.alibou.demo.subject.impl;

import com.alibou.demo.chapter.model.entities.Chapter;
import com.alibou.demo.subject.model.dto.SubjectResponse;
import com.alibou.demo.subject.model.entities.Subject;
import com.alibou.demo.subject.SubjectRepository;
import com.alibou.demo.subject.SubjectService;
import com.alibou.demo.subject.model.mapper.SubjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    private final SubjectMapper subjectMapper;

    public SubjectImpl(SubjectRepository subjectRepository, SubjectMapper subjectMapper) {
        this.subjectRepository = subjectRepository;
        this.subjectMapper = subjectMapper;
    }

    @Override
    public SubjectResponse saveSubject(Subject subject) {

        return subjectMapper.toSubjectResponse(subjectRepository.save(subject));
    }

    @Override
    public SubjectResponse findSubjectById(int id) {
        return subjectMapper.toSubjectResponse(subjectRepository.findById(id).get());
    }

    @Override
    public List<SubjectResponse> findAll() {
        return subjectRepository.findAll()
                .stream()
                .map(subjectMapper::toSubjectResponse)
                .collect(Collectors.toList());
    }



    @Override
    public void deleteById(Integer id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public void update(Subject subject) {
        Subject existSubject = subjectRepository.findById(subject.getId()).get();

        if (existSubject != null){
            existSubject.setName(subject.getName());
            existSubject.setChapters(subject.getChapters());
            existSubject.setStudents(subject.getStudents());

            subjectRepository.save(existSubject);
        }
    }

    @Override
    public List<Chapter> getChaptersByCourseId(int id) {
        Subject subject = subjectRepository.findById(id).get();
        return subject.getChapters();
    }
}
