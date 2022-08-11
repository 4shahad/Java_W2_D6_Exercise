package com.example.employeeexd5w2.Controller;

import com.example.employeeexd5w2.Model.AnnualLeave;
import com.example.employeeexd5w2.Model.ApiResponse;
import com.example.employeeexd5w2.Model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/employee")
public class employeeController {
    private ArrayList<Employee> employees = new ArrayList<>();

    @GetMapping
    public ResponseEntity getEmployee() {
        return ResponseEntity.status(200).body(employees);
    }

    @PostMapping
    public ResponseEntity addEmployee(@RequestBody @Valid Employee employee, Errors error) {
        if (error.hasErrors()) {
            String message = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        employees.add(employee);
        return ResponseEntity.status(201).body(new ApiResponse("Employee added :)", 201));

    }

    @PutMapping("/{index}")
    public ResponseEntity updateEmployee(@RequestBody @Valid Employee employee
            , @PathVariable int index, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        if (index >= employees.size()) {
            return ResponseEntity.status(400).body(new ApiResponse("Invalid index", 400));
        }
        employees.set(index, employee);
        return ResponseEntity.status(201).body(new ApiResponse("Employee updated !", 201));
    }
    @DeleteMapping("/{index}")
    public ResponseEntity deleteEmployee (@PathVariable @Valid int index){
        if(index>=employees.size()){
            return ResponseEntity.status(400).body(new ApiResponse("Invalid index",400));
        }
        employees.remove(index);
        return ResponseEntity.status(200).body(new ApiResponse("Employee deleted !",200));
    }
@PostMapping("/annualleave")
    public ResponseEntity annualLeave
        (@RequestBody @Valid AnnualLeave annualLeave, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
        }
    for (int i = 0; i < employees.size(); i++) {
        if (annualLeave.getID()==employees.get(i).getID()){
            if (employees.get(i).getAnnualLeave()-annualLeave.getAnnualLeave()>0){
                if (employees.get(i).getOnLeave().equals("false")){
                    employees.get(i).setAnnualLeave(employees.get(i).getAnnualLeave()-1);
                    employees.get(i).setOnLeave("true");
                    return ResponseEntity.status(200).body(new ApiResponse("good request",200));
                }

            }
        }

    }

return ResponseEntity.status(400).body(new ApiResponse("bad request",400));}
}