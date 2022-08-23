package com.Faculty.Facultate.controller;

import com.Faculty.Facultate.model.Course;
import com.Faculty.Facultate.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("course")
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/greaterThanThree")
    public List<Course> getAllCoursesCreditPointsGreaterThanThree() {
        return courseService.getAllCoursesCreditPointsGreaterThanThree();
    }

}
