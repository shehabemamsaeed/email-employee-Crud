package com.example.ass2.service;

import com.example.ass2.mapper.EmployeeMapper;
import com.example.ass2.model.Employee;
import com.example.ass2.repo.EmployeeRepo;
import dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public String CreateEmployee(EmployeeDto employeeDto) throws Exception {
        try {

            Employee employee = EmployeeMapper.employeeMapper.ConvertEmployeeDtoToEmployee(employeeDto);
            employeeRepo.save(employee);
            return "Created Account";
        } catch (Exception error) {
            throw new Exception("error is" + error);
        }

    }

    @Override
    public String UpdateEmployee(EmployeeDto employeeDto, Long id) throws Exception {
        try {

            Employee employee = EmployeeMapper.employeeMapper.ConvertEmployeeDtoToEmployeeWithId(employeeDto, id);
            employeeRepo.save(employee);
            return "Updated employee";

        } catch (Exception e) {
            throw new Exception(e);
        }
    }


    @Override
    public String RemoveEmployee(Long id) throws Exception {
      try{
          employeeRepo.deleteById(id);
          return " Deleted Employee";
      }catch (Exception e){
          throw new Exception(e);
      }
    }

    @Override
    public List<EmployeeDto> GetAllEmployee() {
        try{
          List<Employee> employees=  employeeRepo.findAll();

            return EmployeeMapper.employeeMapper.ConvertListEmployeeToListEmployeeDto(employees);
        }catch (Exception e){
        throw new RuntimeException("error "+e);
        }

    }

    @Override
    public EmployeeDto GetEmployeeById(Long id) {
        Employee employee =   employeeRepo.findById(id).get();
       return  EmployeeMapper.employeeMapper.ConvertEmployeeToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> GetEmployeesByListId(List<Long> ids) throws Exception {
        try{
          List<Employee> employees=  employeeRepo.findAllById(ids);
          return EmployeeMapper.employeeMapper.ConvertListEmployeeToListEmployeeDto(employees);
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Override
    public List<EmployeeDto> GetEmployeesByListOfName(List<String> name) throws Exception {
        try{
            List<Employee> employees = employeeRepo.findAllByNameIn(name);
            return EmployeeMapper.employeeMapper.ConvertListEmployeeToListEmployeeDto(employees);
        }catch (Exception e){
            throw new Exception(e);
        }
    }


}
