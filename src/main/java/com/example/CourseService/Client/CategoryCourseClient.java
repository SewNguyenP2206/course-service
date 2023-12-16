package com.example.CourseService.Client;


import com.example.CourseService.DTO.CreateCategoryCourseDTO;
import com.example.CourseService.DTO.ResponeCategoryNameDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "CATEGORYCOURSE-APP",path = "/api/categoryCourse")
public interface CategoryCourseClient {
    @PostMapping("/getCategoriesByCourseID")
    List<ResponeCategoryNameDTO> getCategoriesByCourseID(@RequestParam int id);

    @PostMapping("/deleteCategoryCourse")
    int DeleteCategoryCourseByCourseID(@RequestParam  int courseId);

    @PostMapping("/createCategoryCourse")
    ResponeCategoryNameDTO createCategoryCourse(@RequestBody CreateCategoryCourseDTO dto) ;

}
