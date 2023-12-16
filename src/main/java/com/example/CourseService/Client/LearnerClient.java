package com.example.CourseService.Client;

import com.example.CourseService.DTO.ResponeStudentInfor;
import com.example.CourseService.DTO.ResponseLearnerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "LEARNER-APP",path = "/api/learner")
public interface LearnerClient {
    @PostMapping("/getLearnerByIdAndCourse")
    ResponseLearnerDTO getLearnerByIdAndCourse(@RequestParam int accountId, @RequestParam int CourseId);

    @GetMapping("/getLearnersByCourseId")
    List<ResponseLearnerDTO> getLearnersByCourseId(int courseId);

    @GetMapping("/getCourseLastMonthProfitsByCourseID/{id}")
    int getCourseLastMonthProfitsByCourseID(@PathVariable int id);


    @GetMapping("getCourseProfitsByCourseID/{id}")
    int getCourseProfitsByCourseID( @PathVariable int id);

    @GetMapping("/getStudentsByCourseId/{courseId}")
    List<ResponeStudentInfor> getStudentsByCourseId(@PathVariable int courseId);



}
