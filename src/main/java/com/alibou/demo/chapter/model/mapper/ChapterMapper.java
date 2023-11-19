package com.alibou.demo.chapter.model.mapper;

import com.alibou.demo.chapter.model.dto.ChapterRequest;
import com.alibou.demo.chapter.model.dto.ChapterResponse;
import com.alibou.demo.chapter.model.entities.Chapter;

public class ChapterMapper {

    public ChapterResponse toChapterResponse (Chapter chapter){
        return ChapterResponse.builder()
                .name(chapter.getName())
                .subject(chapter.getSubject())
                .build();
    }

    public Chapter toChapter (ChapterRequest chapterRequest){
        return Chapter.builder()
                .id(chapterRequest.getId())
                .name(chapterRequest.getName())
                .subject(chapterRequest.getSubject())
                .build();
    }

}
