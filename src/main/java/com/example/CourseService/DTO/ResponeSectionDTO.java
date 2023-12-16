package com.example.CourseService.DTO;


import java.util.List;

public class ResponeSectionDTO {

    private Integer id;
    private String name;
    private Integer accountId;
    private Integer courseId;

    private List<ResponeVideoDTO> videos ;

    public List<ResponeVideoDTO> getVideos() {
        return videos;
    }

    public void setVideos(List<ResponeVideoDTO> videos) {
        this.videos = videos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}
