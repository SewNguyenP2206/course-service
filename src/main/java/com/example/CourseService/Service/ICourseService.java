package com.example.CourseService.Service;



import com.example.CourseService.AppServiceExeption;
import com.example.CourseService.DTO.CreateCourseDTO;
import com.example.CourseService.DTO.ResponeAccountDTO;
import com.example.CourseService.DTO.ResponeCourseDTO;
import com.example.CourseService.DTO.ResponeStudentInfor;
import com.example.CourseService.Entity.Course;

import java.util.List;

public interface ICourseService {
    Course createCourse(CreateCourseDTO dto) throws AppServiceExeption;

//    List<ResponeCourseDTO> getCourseList(CourseRepository courseRepository);


    List<ResponeCourseDTO> getCourseList();


    ResponeCourseDTO getCourseByCourseId(int courseId);



     int updateMainImage(int id, String imageName);

     ResponeCourseDTO fromCourseToResponeCourseDTO2(Course course);

     ResponeStudentInfor fromAccountToResponeStudentDTO(ResponeAccountDTO account, int courseID);


     Double getSumPriceCourseByAccountID(int id);


      ResponeCourseDTO fromCourseToResponeCourseDTO(Course course);

      List<ResponeCourseDTO> fromCourseListToResponeCourseDTOList(List<Course> CourseList);

     int updateCourseStatus(int courseId, int status);

     List<ResponeCourseDTO> findCoursesByInstructorId(int id);


     int DeleteCourseByID(int courseId);


     String getNameByID(int id);


}
