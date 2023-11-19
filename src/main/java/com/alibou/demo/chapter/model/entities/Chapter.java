package com.alibou.demo.chapter.model.entities;

import com.alibou.demo.subject.model.entities.Subject;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Chapter {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "sub_id")
    private Subject subject;
}
