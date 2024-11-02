package com.example.ass2.service;

import dto.EmailDto;

import java.util.List;

public interface EmailService {
    String AddEmail(EmailDto emailDto);
    String UpdateEmail(EmailDto emailDto) throws Exception;

    String DeleteAccount(Long id);

    List<EmailDto> GetAllEmails()throws Exception;

    EmailDto GetEmailByName(String name);

    List<EmailDto> GetEmailsByNames(List<String> names);

    EmailDto getEmailByContent(String content);
}
