package com.example.CourseService.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "VIDEO-APP",path = "/api/video")
public interface VideoClient {
    @GetMapping("/deleteVideosBySectionID/{id}")
    int deleteVideosBySectionID( @PathVariable int sectionID);
}
