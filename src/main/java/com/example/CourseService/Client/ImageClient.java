package com.example.CourseService.Client;


import com.example.CourseService.DTO.ResponeImageDTO;
import com.example.CourseService.ResponeObjects.ResponeObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@FeignClient(name = "IMAGE-APP",path = "/api/image")
public interface ImageClient {

    @GetMapping("/getImageByCourseID/{id}")
    ResponeImageDTO getImageByCourseID(@PathVariable int id);

    @GetMapping("/deleteImageByCourseID/{id}")
    int deleteImageByCourseID(int id);


}
