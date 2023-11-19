package com.alibou.demo.subject.model.dto;

import com.alibou.demo.chapter.model.entities.Chapter;
import com.alibou.demo.student.model.entities.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class SubjectResponse {

    private String name;

    private List<Student> students;

    private List<Chapter> chapters;

}
