package com.alibou.demo.chapter;
import com.alibou.demo.chapter.model.dto.ChapterResponse;
import com.alibou.demo.chapter.model.entities.Chapter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChapterService {
    ChapterResponse save(Chapter chapter);

    ChapterResponse findById(int id);

    List<ChapterResponse> findAll();

    void deleteById(Integer id);

    void update(Chapter chapter);
}
