package myHotel.tecnica.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import myHotel.tecnica.dto.EmployeesDto;
import myHotel.tecnica.dto.EmployeesMaxSalaryDto;

@Component
public interface EmployeesDao {
    
    Long getEmployeesBySalaryHigh();
    
    Long getEmployeesBySalaryMedium();
    
    Long getEmployeesBySalaryLow();
    
    List<EmployeesMaxSalaryDto> getEmployeesMaxSalaryByDepartments();

    List<EmployeesDto> getEmployeesMoreExperience();
}
