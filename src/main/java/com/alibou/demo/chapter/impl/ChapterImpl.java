package com.alibou.demo.chapter.impl;

import com.alibou.demo.chapter.model.dto.ChapterResponse;
import com.alibou.demo.chapter.model.entities.Chapter;
import com.alibou.demo.chapter.ChapterRepository;
import com.alibou.demo.chapter.ChapterService;
import com.alibou.demo.chapter.model.mapper.ChapterMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ChapterImpl implements ChapterService {

    private final ChapterRepository chapterRepository;

    private final ChapterMapper chapterMapper;

    public ChapterImpl(ChapterRepository chapterRepository, ChapterMapper chapterMapper){

        this.chapterRepository = chapterRepository;
        this.chapterMapper = chapterMapper;
    }

    @Override
    public ChapterResponse save(Chapter chapter) {
        return chapterMapper.toChapterResponse(chapterRepository.save(chapter));
    }

    @Override
    public ChapterResponse findById(int id) {
        Chapter chapter = chapterRepository.findById(id).get();
        return chapterMapper.toChapterResponse(chapter);
    }

    @Override
    public List<ChapterResponse> findAll() {
        return chapterRepository.findAll()
                .stream()
                .map(chapterMapper::toChapterResponse)
                .collect(Collectors.toList());

    }

    @Override
    public void deleteById(Integer id) {
        chapterRepository.deleteById(id);
    }

    @Override
    public void update(Chapter chapter) {
        Chapter existChapter = chapterRepository.findById(chapter.getId()).get();

        if (existChapter != null){
            existChapter.setName(chapter.getName());
            existChapter.setSubject(chapter.getSubject());
          chapterRepository.save(existChapter);
        }

    }
}
