package com.example.jwt.Repository;

import com.example.jwt.DTO.EmployeeDTO;
import com.example.jwt.Entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Employee findByUsername(String username);

}

