package com.example.ass2.mapper;

import org.mapstruct.Mapper;
import com.example.ass2.model.Employee;
import dto.EmployeeDto;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper
public interface EmployeeMapper {


    EmployeeMapper employeeMapper = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto ConvertEmployeeToEmployeeDto(Employee employee);
    Employee ConvertEmployeeDtoToEmployee(EmployeeDto employeeDto);
    Employee ConvertEmployeeDtoToEmployeeWithId(EmployeeDto employeeDto,Long id);
    List<EmployeeDto> ConvertListEmployeeToListEmployeeDto(List<Employee> employee);
    List<Employee> ConvertListEmployeeDtoToListEmployee(List<EmployeeDto> employee);


}
