package myHotel.tecnica.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Data
public class DepartmentsMixDto {

    @JsonProperty("DEPARTMENT_ID")
    private BigDecimal departmentId;
    @JsonProperty("SALARY_GROUP")
    private String salaryGroup;
    @JsonProperty("CANTIDAD")
    private Long cantidad;
    
}
