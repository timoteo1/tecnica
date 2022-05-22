package myHotel.tecnica.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EmployeesMaxSalaryDto {
    
    @JsonProperty("MAX_SALARY")
    private BigDecimal maxSalary;
    @JsonProperty("EMPLOYEE_ID")
    private BigDecimal employeeId;
    @JsonProperty("JOB_ID")
    private String jobId;
    @JsonProperty("DEPARTMENT_ID")
    private BigDecimal departmentId;
    
}
