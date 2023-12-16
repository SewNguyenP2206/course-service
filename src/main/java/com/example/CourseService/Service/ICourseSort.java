package com.example.CourseService.Service;


import com.example.CourseService.Entity.Course;

import java.util.List;

public interface ICourseSort {
    List<Course> findAllByOrderByPriceDesc();
    List<Course> findAllByOrderByPriceAsc();
    List<Course> findAllByOrderByDateDesc();
    List<Course> findAllByOrderByDateAsc();
}
