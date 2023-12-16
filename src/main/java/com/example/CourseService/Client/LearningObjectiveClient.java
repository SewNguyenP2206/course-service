package com.example.CourseService.Client;

import com.example.CourseService.DTO.CreateLearningObjectiveDTO;
import com.example.CourseService.DTO.ResponeLearningObjectiveDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@FeignClient(name = "LEARNINGOBJECTIVE-APP",path = "/api/learningObjective")
public interface LearningObjectiveClient {
    @GetMapping("/getLearningObjectiveByCourseId/{ID}")
    ResponeLearningObjectiveDTO getLearningObjectiveByCourseId(@PathVariable int ID);

    @PostMapping("/addLearningObjective")
    @ResponseStatus(HttpStatus.CREATED)
    ResponeLearningObjectiveDTO createLearningObjective(@RequestBody CreateLearningObjectiveDTO dto) throws IOException;

    @PostMapping("/deleteLearningObjectivesByCourseId")
    public int DeleteLearningObjectivesByCourseID(int courseId);
}
