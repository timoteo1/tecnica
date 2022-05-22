package myHotel.tecnica.dao;

import java.util.List;

import myHotel.tecnica.dto.DepartmentsAvgSalaryDto;
import myHotel.tecnica.dto.DepartmentsMixDto;

public interface DepartmentsSalaryDao {

    List<DepartmentsMixDto> getSalaryByDepartments();
    
    List<DepartmentsAvgSalaryDto> getDeparmentsAvgSalary();
}
