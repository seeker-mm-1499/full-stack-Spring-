package com.jdc.demo.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.entity.Course;

public interface CourseRepo extends JpaRepositoryImplementation<Course, Integer>{

}
