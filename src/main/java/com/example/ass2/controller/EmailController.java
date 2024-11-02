package com.example.ass2.controller;

import com.example.ass2.service.EmailService;
import dto.EmailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/Email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/AddEmail")
    ResponseEntity<String> addEmail(@RequestBody EmailDto emailDto) {
    String message =  emailService.AddEmail(emailDto);
     return ResponseEntity.created(URI.create("/Email/AddEmail")).body(message);
    }

    @PutMapping("/UpdateEmail")
    ResponseEntity<String> UpdateEmail(@RequestBody EmailDto emailDto) throws Exception{
      String message =  emailService.UpdateEmail(emailDto);
    return ResponseEntity.ok(message);
    }
    @DeleteMapping("/DeleteEmail")
    ResponseEntity<String> DeleteEmailC(@RequestParam Long id) {
        String message= emailService.DeleteAccount(id);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/GetAllEmails")
    ResponseEntity<List<EmailDto>> GetAllEmails()throws Exception{
      List<EmailDto> emailDtos=  emailService.GetAllEmails();
        return ResponseEntity.ok(emailDtos);
    }

    @GetMapping("/GetEmailByName")
   ResponseEntity< EmailDto> GetEmailByName(@RequestParam String name)throws Exception{
        EmailDto emailDto=emailService.GetEmailByName(name);
        return  ResponseEntity.ok(emailDto);
    }


    @GetMapping("/GetEmailsByNames")
    ResponseEntity<List<EmailDto>> GetEmailsByNames(@RequestParam("name") List<String> names){
        List<EmailDto> emailDtos=emailService.GetEmailsByNames(names);
        return ResponseEntity.ok(emailDtos);
    }
    @GetMapping("/GetEmailByContent")
    ResponseEntity<EmailDto> GetEmailByContent(@RequestParam("content") String content){
        EmailDto emailDto= emailService.getEmailByContent(content);
        return  ResponseEntity.ok(emailDto);
    }


}
