package com.alibou.demo.chapter.impl;

import com.alibou.demo.chapter.model.entities.Chapter;
import com.alibou.demo.chapter.ChapterRepository;
import com.alibou.demo.chapter.ChapterService;

import java.util.List;

public class ChapterImpl implements ChapterService {

    private final ChapterRepository chapterRepository;

    public ChapterImpl(ChapterRepository chapterRepository){

        this.chapterRepository = chapterRepository;
    }

    @Override
    public Chapter save(Chapter chapter) {
        return chapterRepository.save(chapter);
    }

    @Override
    public Chapter findById(int id) {
        return chapterRepository.findById(id).get();
    }

    @Override
    public List<Chapter> findAll() {
        return chapterRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        chapterRepository.deleteById(id);
    }

    @Override
    public void update(Chapter chapter) {
        Chapter existChapter = findById(chapter.getId());

        if (existChapter != null){
            existChapter.setName(chapter.getName());
            existChapter.setSubject(chapter.getSubject());
          chapterRepository.save(existChapter);
        }

    }
}
