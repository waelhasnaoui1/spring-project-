package com.alibou.demo.subject;

import com.alibou.demo.subject.model.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {
}
