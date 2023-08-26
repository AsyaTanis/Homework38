package com.example.logging.controller;

import com.example.logging.dto.EmployeeDTO;
import com.example.logging.model.EmployeeEntity;
import com.example.logging.service.EmployeeFileService;
import com.example.logging.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeFileService employeeFileService;

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeEntity employee) {
        return employeeService.createEmployee(employee);
    }
    @PutMapping("/{id}")
    public EmployeeDTO updateEmployeeById(@PathVariable int id,
                                          @RequestBody EmployeeEntity employee) {
        return employeeService.updateEmployeeById(id, employee);
    }

    @GetMapping("/{id}/fullInfo")
    public EmployeeDTO getInformationForEmployee(@PathVariable int id) {
        return employeeService.getInformationForEmployee(id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        employeeService.deleteById(id);
    }

    @GetMapping("/salaryHigherThan")
    public Collection<EmployeeDTO> getEmployeesBySalaryGreaterThan(@RequestParam double salary)  {
        return employeeService.getEmployeesBySalaryGreaterThan(salary);
    }
    @GetMapping
    public Collection<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployee();
    }
    @GetMapping("/position")
    public List<EmployeeDTO> getEmployeeByPosition(@RequestParam("position") Optional position) {
        if (position.isEmpty()) {
            return employeeService.getAllEmployee();
        } else
            return employeeService.getEmployeeByPosition(position);
    }
    @GetMapping("/page")
    public List<EmployeeEntity> getEmployeesByPage(int number) {
        return employeeService.getEmployeesByPage(number);
    }
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void processJsonFile(@RequestParam("file") MultipartFile file) {
        employeeFileService.processJsonFile(file);
    }
}