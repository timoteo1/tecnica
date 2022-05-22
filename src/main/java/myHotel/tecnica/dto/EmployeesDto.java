package myHotel.tecnica.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class EmployeesDto {

    @JsonProperty("EMPLOYEE_ID")
    private BigDecimal employeeId;
    @JsonProperty("FIRST_NAME")
    private String firstName;
    @JsonProperty("LAST_NAME")
    private String lastName;
    private String email;
    @JsonProperty("PHONE_NUMBER")
    private String phoneNumber;
    @JsonProperty("HIRE_DATE")
    private Date hireDate;
    @JsonProperty("JOB_ID")
    private String jobId;
    private BigDecimal salary;
    @JsonProperty("COMMISSION_PCT")
    private BigDecimal commisionPct;
    @JsonProperty("MANAGER_ID")
    private BigDecimal managerId;
    @JsonProperty("DEPARTMENT_ID")
    private BigDecimal departmentId;
    
}
