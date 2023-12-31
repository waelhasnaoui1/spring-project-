package com.alibou.demo.chapter;

import com.alibou.demo.chapter.model.dto.ChapterResponse;
import com.alibou.demo.chapter.model.entities.Chapter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/chapters")
public class ChapterController {

    private final ChapterService chapterService;

    public ChapterController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @GetMapping()
    public List<ChapterResponse> getAllChapter (){
        return this.chapterService.findAll();
    }

    @GetMapping("/{id}")
    public ChapterResponse getChapterById(@PathVariable("id") int id){
        return chapterService.findById(id);
    }

    @PostMapping()
    public ChapterResponse crateChapter (@RequestBody Chapter chapter){
        return chapterService.save(chapter);
    }

    @DeleteMapping("{id}")
    public void deleteChapter (@PathVariable("id") int id){
         chapterService.deleteById(id);
    }

}
