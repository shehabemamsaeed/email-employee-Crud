package com.example.ass2.repo;

import com.example.ass2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
 List<Employee> findAllByNameIn(List<String> name);
}
