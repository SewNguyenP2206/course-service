    package com.example.CourseService.DTO;


import java.util.ArrayList;
import java.util.List;


public class ResponeAccountDTO {

    public static ResponeAccountDTO fromAccount(CreateAccountDTO account) {
        ResponeAccountDTO accountResponseDTO = new ResponeAccountDTO();
        accountResponseDTO.setId(account.getId());
        accountResponseDTO.setImage(account.getImage());
        accountResponseDTO.setUsername(account.getUsername());
        accountResponseDTO.setAddress(account.getAddress());
        accountResponseDTO.setBio(account.getBio());
        accountResponseDTO.setLastname(account.getLastname());
        accountResponseDTO.setFirstname(account.getFirstname());
        accountResponseDTO.setEmail(account.getEmail());
        accountResponseDTO.setRoleId(account.getRoleId());
        accountResponseDTO.setTwitter(account.getTwitter());
        accountResponseDTO.setFacebook(account.getFacebook());
        accountResponseDTO.setPassword(account.getPassword());
        accountResponseDTO.setToken(account.getToken());
        accountResponseDTO.setIsPremium(account.getIsPremium());
        accountResponseDTO.setPhone(account.getPhone());
        accountResponseDTO.setIsActive(account.getIsActive());
        return accountResponseDTO;
    }




    public static List<ResponeAccountDTO> fromAccountList(List<CreateAccountDTO> accountList) {
        List<ResponeAccountDTO> accountResponseDTOList = new ArrayList<>();
        for (CreateAccountDTO account : accountList) {
            accountResponseDTOList.add(fromAccount(account));
        }
        return accountResponseDTOList;
    }

    private int id;

    private String username;


    private String password;


    private String address;


    private String lastname;


    private String firstname;


    private String phone;


    private String image;


    private String email;


    private int roleId;


    private String twitter;


    private String facebook;

    private  String bio;

    private  int isActive;

    private  String token;

    private  int isPremium;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public int getIsPremium() {
        return isPremium;
    }

    public void setIsPremium(int isPremium) {
        this.isPremium = isPremium;
    }
}