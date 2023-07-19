package com.csi.controller;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepositoryImpl;


    @GetMapping("/hello")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Welcome to fintech csi");
    }

    @GetMapping("/listofemployee")
    public ResponseEntity<List<Employee>> getAllData(){

        return ResponseEntity.ok(Stream.of(new Employee(1,"SURAJ",96520),
                new Employee(2,"RAHUL",75210),
                new Employee(3,"PREETI",65210),
                new Employee(4,"AISHWARYA",55540)).collect(Collectors.toList()));

    }

    @GetMapping("/userinfo")
    public ResponseEntity<Principal> userInfo(Principal principal){
        return ResponseEntity.ok(principal);

    }

    @GetMapping("/datafromDB")
    public ResponseEntity<List<Employee>> dataFromDB(){
        return ResponseEntity.ok(employeeRepositoryImpl.findAll());

    }

}
