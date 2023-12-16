package com.example.CourseService.Client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "COURSERATE-APP",path = "/api/rate")
public interface CourseRateClient {
    @PostMapping("/avgCourseRate")
    public ResponseEntity<Float> avgCourseRate(@RequestParam Integer courseId);


    @PostMapping("/countCourseRate")
     ResponseEntity<Integer> countCourseRate(@RequestParam Integer courseId);

}
