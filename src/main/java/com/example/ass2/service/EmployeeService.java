package com.example.ass2.service;

import com.example.ass2.model.Employee;
import dto.EmployeeDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
   String CreateEmployee(EmployeeDto employeeDto) throws Exception;
    String UpdateEmployee(EmployeeDto employeeDto,Long id) throws Exception;

  String RemoveEmployee(Long id) throws Exception;
    List<EmployeeDto> GetAllEmployee();
    EmployeeDto GetEmployeeById(Long id);

    List<EmployeeDto> GetEmployeesByListId(List<Long> id) throws Exception;

    List<EmployeeDto> GetEmployeesByListOfName(List<String> name)throws  Exception;
}
