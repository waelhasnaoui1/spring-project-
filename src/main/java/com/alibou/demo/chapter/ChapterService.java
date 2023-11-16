package com.alibou.demo.chapter;
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
