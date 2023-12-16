package com.example.CourseService.Service;


import com.example.CourseService.Client.*;
import com.example.CourseService.Config.ModelMapperObject;
import com.example.CourseService.DTO.*;
import com.example.CourseService.Entity.Course;
import com.example.CourseService.Repsitory.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ServiceOfCourse implements ICourseService {


    @Autowired
    private CourseRepository courseRepository;


    @Autowired
    private ModelMapperObject modelMapper;

    @Autowired
    private LearningObjectiveClient learningObjectiveClient;
    
    @Autowired
    AccountClient accountClient;

    @Autowired
    LearnerClient learnerClient;

    @Autowired
    CategoryCourseClient categoryCourseClient;

    @Autowired
    CourseRateClient courseRateClient;

    @Autowired
    ImageClient imageClient;

    @Autowired
    SectionClient sectionClient;



    public ServiceOfCourse() {
    }

    @Override
    public Course createCourse(CreateCourseDTO dto) {
        Course course = new Course();
        course.setCoupon(dto.getCoupon());
        course.setDescription(dto.getDescription());
        course.setIntroduction(dto.getIntroduction());
        course.setLanguage(dto.getLanguage());
        course.setLevel(dto.getLevel());
        course.setPrice(dto.getPrice());
        course.setName(dto.getName());
        course.setPassed(dto.isPassed());
        course.setAccountId(dto.getAccountId());
        return courseRepository.save(course);
    }





    @Override
    public String getNameByID(int id)
    {
       return courseRepository.findById(id).get().getName();
    }

    @Override
    public int DeleteCourseByID(int courseId)
    {
        return courseRepository.deleteViolatedCourse(courseId);
    }


    @Override
    public List<ResponeCourseDTO> findCoursesByInstructorId(int id) {
        return courseRepository.findCoursesByInstructorId(id).stream().map(course -> fromCourseToResponeCourseDTO2(course)).toList();
    }



    @Override
    public Double getSumPriceCourseByAccountID(int id) {
        return null;
    }


    @Override
    public int updateCourseStatus(int courseId, int status)
    {
        return courseRepository.updateCourseStatus(courseId, status);
    }


    @Override
    public int updateMainImage(int id, String imageName)
    {
        return courseRepository.updateMainImage(id,imageName);
    }

    @Override
    public ResponeCourseDTO fromCourseToResponeCourseDTO2(Course course) {
        ResponeCourseDTO courseDTO = new ResponeCourseDTO();
        ResponeAccountDTO accDTO = accountClient.getAccountInformation(course.getAccountId()).getBody();
        courseDTO.setName(course.getName());
        courseDTO.setPrice(course.getPrice());
        courseDTO.setInstructorName(accDTO.getFirstname()+" "+accDTO.getLastname());
        courseDTO.setImage(course.getImage());
        courseDTO.setStudents(learnerClient.getStudentsByCourseId(course.getId()));//FeignCall
        return courseDTO;
    }

    @Override
    public ResponeStudentInfor fromAccountToResponeStudentDTO(ResponeAccountDTO account, int courseID) {
        ResponeStudentInfor student = new ResponeStudentInfor();
        student.setId(account.getId());
        student.setEmail(account.getEmail());
        student.setFacebook(account.getFacebook());
        student.setFirstname(account.getFirstname());
        student.setTwitter(account.getTwitter());
        student.setLastname(account.getLastname());
        student.setDate(learnerClient.getLearnerByIdAndCourse(account.getId(),courseID).getDate());//FeignCall
        return  student;
    }


    public  ResponeCourseDTO fromCourseToResponeCourseDTO3(Course course) {
        ResponeCourseDTO courseDTO = new ResponeCourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setIntroduction(course.getIntroduction());
        courseDTO.setLevel(course.getLevel());
        courseDTO.setLanguage(course.getLanguage());
        courseDTO.setPrice(course.getPrice());
        courseDTO.setCoupon(course.getCoupon());
        courseDTO.setPassed(course.getPassed());
        courseDTO.setStatus(course.getStatus());
        courseDTO.setImage(course.getImage());
        courseDTO.setDate(course.getDate());
        courseDTO.setAccountId(course.getAccountId());//FeignCall
        return courseDTO;
    }


    @Override
    public  ResponeCourseDTO fromCourseToResponeCourseDTO(Course course) {
        ResponeAccountDTO accDTO = accountClient.getAccountInformation(course.getAccountId()).getBody();
        ResponeCourseDTO courseDTO = new ResponeCourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setIntroduction(course.getIntroduction());
        courseDTO.setLevel(course.getLevel());
        courseDTO.setLanguage(course.getLanguage());
        courseDTO.setPrice(course.getPrice());
        courseDTO.setCoupon(course.getCoupon());
        courseDTO.setPassed(course.getPassed());
        courseDTO.setStatus(course.getStatus());
        courseDTO.setImage(course.getImage());
        courseDTO.setDate(course.getDate());
        courseDTO.setBio(accDTO.getBio());
        courseDTO.setAccountId(accDTO.getId());
        courseDTO.setInstructorName(accDTO.getFirstname()+" "+accDTO.getLastname());
        courseDTO.setInstructorImage(accDTO.getImage());
        courseDTO.setInstructorAddress(accDTO.getAddress());
        courseDTO.setInstructorEmail(accDTO.getEmail());
        courseDTO.setInstructorFacebook(accDTO.getFacebook());
        courseDTO.setInstructorPhone(accDTO.getPhone());
        courseDTO.setInstructorTwitter(accDTO.getTwitter());
        courseDTO.setCategories(categoryCourseClient.getCategoriesByCourseID(course.getId()));//FeignCall
        courseDTO.setLearningObjective(learningObjectiveClient.getLearningObjectiveByCourseId(course.getId()));//FeignCall
        courseDTO.setSections(sectionClient.getSectionByCourseID(course.getId()));//FeignCall
        courseDTO.setCount(courseRateClient.countCourseRate(course.getId()).getBody());//FeignCall
        courseDTO.setImages(imageClient.getImageByCourseID(course.getId()));//FeignCall
        courseDTO.setAvg(courseRateClient.avgCourseRate(course.getId()).getBody());//FeignCall
        return courseDTO;
    }





    public ResponeCourseProfitDTO fromCourseToCourseProfitDTO(Course course)
    {
        ResponeCourseProfitDTO responeCourseProfitDTO = new ResponeCourseProfitDTO();
        responeCourseProfitDTO.setSumProfit(learnerClient.getCourseProfitsByCourseID(course.getId()));
        responeCourseProfitDTO.setLastMonthProfit(learnerClient.getCourseLastMonthProfitsByCourseID(course.getId()));
        responeCourseProfitDTO.setName(course.getName());
        responeCourseProfitDTO.setImage(course.getImage());
        responeCourseProfitDTO.setCourseId(course.getId());
        return  responeCourseProfitDTO;
    }



@Override
    public  List<ResponeCourseDTO> fromCourseListToResponeCourseDTOList(List<Course> CourseList) {
        List<ResponeCourseDTO> ResponeCourseDTOList = new ArrayList<>();
        for (Course course : CourseList) {

            ResponeCourseDTOList.add(fromCourseToResponeCourseDTO(course));
        }
        return ResponeCourseDTOList;
    }




    @Override
    public List<ResponeCourseDTO> getCourseList() {

            return courseRepository.findAll().stream().map(course -> fromCourseToResponeCourseDTO(course)).toList();

    }

    @Override
    public ResponeCourseDTO getCourseByCourseId(int courseId) {
        return fromCourseToResponeCourseDTO(courseRepository.findById(courseId).orElseThrow());
    }


    public List<Course> getCourseList2() {
        return courseRepository.findAll();
    }

}
