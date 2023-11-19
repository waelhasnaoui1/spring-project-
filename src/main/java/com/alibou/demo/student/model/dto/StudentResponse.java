package com.alibou.demo.student.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponse {

    private String firstname;
    private String lastname;
    private int age;
    private int nbrSubjects;
}
