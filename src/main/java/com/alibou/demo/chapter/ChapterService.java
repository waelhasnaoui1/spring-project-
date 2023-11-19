package com.alibou.demo.chapter;
import com.alibou.demo.chapter.model.entities.Chapter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChapterService {
    Chapter save(Chapter chapter);

    Chapter findById(int id);

    List<Chapter> findAll();

    void deleteById(Integer id);

    void update(Chapter chapter);
}
