package com.example.CourseService.Client;


import com.example.CourseService.DTO.ResponeAccountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ACCOUNT-APP",path = "/api/accounts")
public interface AccountClient {
    @GetMapping("/getAccount/{id}")
    public ResponseEntity<ResponeAccountDTO> getAccountInformation(@PathVariable int id);

}
