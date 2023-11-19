package com.alibou.demo.chapter.model.dto;

import com.alibou.demo.subject.model.entities.Subject;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ChapterResponse {

    private String name;

    private Subject subject;
}
