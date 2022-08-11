package com.example.employeeexd5w2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor @Data
public class AnnualLeave {
    @NotNull(message= " annualLeave  can't be Empty !")
    @Range(max=30, message = " annualLeave have to be number  ! ")
    private int annualLeave;
    @Pattern(regexp = "^(?i)(true|false)$", message = "onLeave must be just True or False !")
    private String onLeave="false" ;
    @NotNull(message= " ID can't be Empty !")
    @Range(min = 3, message = "ID must be more than 2 number !")
    private int ID;
}
