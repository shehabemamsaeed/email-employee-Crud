package com.example.ass2.service;

import com.example.ass2.mapper.EmailMapper;
import com.example.ass2.model.Email;
import com.example.ass2.repo.EmailRepo;
import dto.EmailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    EmailRepo emailRepo;


    @Override
    public String AddEmail(EmailDto emailDto) {
       Email email  = EmailMapper.emailMapper.ConvertEmailDtoToEmail(emailDto);
       emailRepo.save(email);
       return  "Inserted Data";
    }

    @Override
    public String UpdateEmail(EmailDto emailDto) {
        Email email= EmailMapper.emailMapper.ConvertEmailDtoToEmail(emailDto);
        emailRepo.save(email);
        return  "Updated Data";
    }

    @Override
    public String DeleteAccount(Long id) {
        emailRepo.deleteById(id);
        return "Deleted Email";
    }

    @Override
    public List<EmailDto> GetAllEmails()throws Exception {
      List<Email> emails=  emailRepo.findAll();
    List<EmailDto> emailDtos = EmailMapper.emailMapper.ConvertEmailsToEmailsDto(emails);
    return emailDtos;

    }

    @Override
    public EmailDto GetEmailByName(String name) {
       Email email =  emailRepo.findByName(name);
        return  EmailMapper.emailMapper.ConvertEmailToEmailDto(email);
    }

    @Override
    public List<EmailDto> GetEmailsByNames(List<String> names) {
        List<Email> emails = emailRepo.findAllByNameIn(names);
        return EmailMapper.emailMapper.ConvertEmailsToEmailsDto(emails);
    }

    @Override
    public EmailDto getEmailByContent(String content) {
        Email email= emailRepo.findByContent(content);
        return EmailMapper.emailMapper.ConvertEmailToEmailDto(email);
    }
}
