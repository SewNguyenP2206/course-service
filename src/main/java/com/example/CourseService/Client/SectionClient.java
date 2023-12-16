package com.example.CourseService.Client;


import com.example.CourseService.DTO.CreateSectionDTO;
import com.example.CourseService.DTO.ResponeSectionDTO;
import com.example.CourseService.ResponeObjects.ResponeObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@FeignClient(name = "SECTION-APP",path = "/api/section")
public interface SectionClient {
    @PostMapping("/addSection")
    @ResponseStatus(HttpStatus.CREATED)
    ResponeSectionDTO createSection(@RequestBody CreateSectionDTO dto) throws IOException;

    @GetMapping("/getSection/{id}")
    List<ResponeSectionDTO> getSectionByCourseID(@PathVariable int id);

    @GetMapping("/deleteSectionByCourseID/{courseId}")
    public int deleteSectionByCourseID( @PathVariable int courseId);
}
