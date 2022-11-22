package com.nhnacademy.edu.jdbc1.service.course;

import com.nhnacademy.edu.jdbc1.domain.Subject;
import com.nhnacademy.edu.jdbc1.domain.Teacher;

import java.util.Date;

public class Course {

    private Long id;
    private final Subject subject;
    private final Teacher teacher;
    private final Date createdAt;

    public Course(Long id, Subject subject, Teacher teacher, Date createdAt) {
        this.id = id;
        this.subject = subject;
        this.teacher = teacher;
        this.createdAt = createdAt;
    }

    public Course(Subject subject, Teacher teacher, Date createdAt) {
        this.subject = subject;
        this.teacher = teacher;
        this.createdAt = createdAt;
    }



    public Long getId() {
        return id;
    }

    public Subject getSubject() {
        return subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", subject=" + subject +
                ", teacher=" + teacher +
                ", createdAt=" + createdAt +
                '}';
    }
}

