package com.mas.travels.controlers.admin;

import com.mas.travels.models.dto.request.AddEmployeeDTO;
import com.mas.travels.models.dto.response.EmployeeResponseDTO;
import com.mas.travels.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("admin/employee")
public class AdminEmployeeController {

    private final EmployeeService employeeService;

    @GetMapping()
    public ResponseEntity<?>getEmployees() {
        try {
            return new ResponseEntity<>(employeeService.getAllEmployees().stream().map(EmployeeResponseDTO::new).collect(Collectors.toSet()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<?> addEmployee(@RequestBody AddEmployeeDTO employeeDTO){
        try {
            return new ResponseEntity<>(employeeService.addNewEmployee(employeeDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    };

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long employeeId) throws EntityNotFoundException {
        try {
            employeeService.deleteEmployee(employeeId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    };

    public void calculateSalary(){};
}
