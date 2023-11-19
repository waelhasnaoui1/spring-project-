package com.alibou.demo.chapter.model.dto;

import com.alibou.demo.subject.model.entities.Subject;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ChapterRequest {


    private Integer id;

    private String name;

    private Subject subject;

}
