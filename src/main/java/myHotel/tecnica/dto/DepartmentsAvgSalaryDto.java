package myHotel.tecnica.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DepartmentsAvgSalaryDto {
    
    @JsonProperty("AVG_SALARY")
    private BigDecimal avgSalary;
    @JsonProperty("DEPARTMENT_ID")
    private BigDecimal departmentId;
    
}
