package myHotel.tecnica.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EmployeesByCountryDto {

    @JsonProperty("COUNTRY_ID")
    private String countryId;
    @JsonProperty("COUNTRY_NAME")
    private String countryName;
    @JsonProperty("REGION_ID")
    private BigDecimal regionId;
    @JsonProperty("ANTIQUITY_AVG_YEARS")
    private BigDecimal antiquityAvgYears;
    @JsonProperty("MAX_SALARY")
    private BigDecimal maxSalary;
    @JsonProperty("MIN_SALARY")
    private BigDecimal minSalary;
    @JsonProperty("EMPLOYEE_QUANTITY")
    private Integer employeeQuantity;
}
