package com.alibou.demo.subject.model.entities;

import com.alibou.demo.chapter.model.entities.Chapter;
import com.alibou.demo.student.model.entities.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subject {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "subjects")
    @JsonBackReference
    private List<Student> students;

    @OneToMany(mappedBy = "subject")
    private List<Chapter> chapters;
}
