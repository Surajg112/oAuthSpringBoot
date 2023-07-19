package com.csi;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class OauthspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthspringbootApplication.class, args);
	}

	@Autowired
	EmployeeRepository employeeRepositoryImpl;

	@PostConstruct
	public void saveData(){
		List<Employee> employee = Stream.of(new Employee(11,"AKSHADA",65232),
				new Employee(12,"SOPHIA",85232),
				new Employee(13,"JOHN",64785)).collect(Collectors.toList());
		employeeRepositoryImpl.saveAll(employee);

	}


}
