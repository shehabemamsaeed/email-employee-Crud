package com.example.ass2.mapper;

import com.example.ass2.model.Email;
import dto.EmailDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmailMapper {

EmailMapper emailMapper = Mappers.getMapper(EmailMapper.class);

Email ConvertEmailDtoToEmail(EmailDto emailDto);
EmailDto ConvertEmailToEmailDto(Email emailDto);
List<EmailDto> ConvertEmailsToEmailsDto(List<Email> emailDtos);

}
