package com.alibou.demo.subject;

import com.alibou.demo.chapter.Chapter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;


    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping()
    public List<Subject> getAllSubjects(){
        return subjectService.findAll();
    }

    @GetMapping("{id}")
    public Subject getSubjectById(@PathVariable("id") int id){
        return subjectService.findSubjectById(id);
    }

    @PostMapping()
    public Subject crateChapter (@RequestBody Subject subject){
        return subjectService.saveSubject(subject);
    }

    @DeleteMapping("{id}")
    public void deleteChapter (@PathVariable("id") int id){
        subjectService.deleteById(id);
    }

    @GetMapping("/{id}/chapters")
    public List<Chapter> getChaptersByCourseId (@PathVariable("id") int id){
        return subjectService.getChaptersByCourseId(id);
    }
}
