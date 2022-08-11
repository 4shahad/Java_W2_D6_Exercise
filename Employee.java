package com.example.employeeexd5w2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class Employee {
    @NotNull(message= " ID can't be Empty !")
    @Range(min = 3, message = "ID must be more than 2 number !")
    private int ID;
    @NotEmpty(message= " Name  can't be Empty !")
    @Size(min = 5, message = "Name  must be more than 4 Character !")
    private String Name ;
    @NotNull(message= " Age  can't be Empty !")
    @Range(min=18, message = " Age have to be just number and have to be +17! ")
    private int Age ;
    @Pattern(regexp = "^(?i)(true|false)$", message = "onLeave must be just True or False !")
    private String onLeave = "false" ;
    @NotNull(message= " employmentYear  can't be Empty !")
    @Range(min = 1900, max = 2022)
    private int employmentYear;
    @NotNull(message= " annualLeave  can't be Empty !")
    @Range(max=30, message = " annualLeave have to be number  ! ")
    private int annualLeave;

}
