package com.example.ass2.controller;

import com.example.ass2.service.EmployeeService;
import dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;


    @PostMapping("/CreatedEmployee")
    ResponseEntity<String> CreatedAccount(@RequestBody EmployeeDto employeeDto) throws Exception {
        String message = employeeService.CreateEmployee(employeeDto);
        return ResponseEntity.created(URI.create("/Employee/CreatedEmployee")).body(message);
    }

    @PutMapping("/UpdatedEmployee")
    ResponseEntity<String> UpdatedAccount(@RequestBody EmployeeDto employeeDto, @RequestParam("ID") Long id)
            throws Exception {
        String message = employeeService.UpdateEmployee(employeeDto, id);
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/DeletedEmployee")
    ResponseEntity<String> RemoveAccount(@RequestParam("id") Long id) throws Exception {
        String message = employeeService.RemoveEmployee(id);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/GetEmployees")
    ResponseEntity<List<EmployeeDto>> GetAccounts() {
        employeeService.GetAllEmployee();
        return ResponseEntity.ok(employeeService.GetAllEmployee());
    }

    @GetMapping("/GetEmployeeById")
    ResponseEntity<EmployeeDto> GetEmployeeById(@RequestParam("id") long id){

        return  ResponseEntity.ok( employeeService.GetEmployeeById(id));
    }
    @GetMapping("/GetEmployeesByIds")
        ResponseEntity<List<EmployeeDto>> GetEmployeesByIds(@RequestParam("id") List<Long> id) throws Exception {
      return   ResponseEntity.ok(employeeService.GetEmployeesByListId(id));
    }

    @GetMapping("/GetEmployeesByNames")
    ResponseEntity<List<EmployeeDto>> GetEmployeesByNames(@RequestParam("name") List<String> names) throws Exception {
        return ResponseEntity.ok(employeeService.GetEmployeesByListOfName(names));
    }
}

