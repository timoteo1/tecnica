package myHotel.tecnica.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import myHotel.tecnica.dao.CountriesDao;
import myHotel.tecnica.dao.DepartmentsSalaryDao;
import myHotel.tecnica.dao.EmployeesDao;
import myHotel.tecnica.dto.CountEmployeesDto;
import myHotel.tecnica.dto.DepartmentsAvgSalaryDto;
import myHotel.tecnica.dto.DepartmentsMixDto;
import myHotel.tecnica.dto.EmployeesByCountryDto;
import myHotel.tecnica.dto.EmployeesDto;
import myHotel.tecnica.dto.EmployeesMaxSalaryDto;


@RestController
@RequestMapping("/api")
public class MyHotelController {

    Logger logger = Logger.getLogger("MtHotelController");
    
    @Autowired
    EmployeesDao employeesDao;

    @Autowired
    DepartmentsSalaryDao departmentsSalary;
    
    @Autowired
    CountriesDao countriesDao;
    
    @GetMapping("/employees/salary/{segment}")
    private CountEmployeesDto getEmployeesHighSalary(@PathVariable String segment){
        try {
            switch (segment) {
            case "A":                
                return new CountEmployeesDto(employeesDao.getEmployeesBySalaryLow());
            case "B":
                return new CountEmployeesDto(employeesDao.getEmployeesBySalaryMedium());                
            case "C":                
                return new CountEmployeesDto(employeesDao.getEmployeesBySalaryHigh());
            default:
                logger.warning("Se ingreso un tipo de salario no valido");
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
           }
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Se ingreso un tipo de salario no valido");
        }
    }
    
    @GetMapping("/departments/salary")
    private List<DepartmentsMixDto> getDepartmentsSalaryGroup(){
        
        return departmentsSalary.getSalaryByDepartments();
    }
    
    @GetMapping("/departments/employees/maxsalary")
    private List<EmployeesMaxSalaryDto> getEmployeesMaxSalary(){
        
        return employeesDao.getEmployeesMaxSalaryByDepartments();
    }
    
    @GetMapping("/employees/moreexperience")
    private List<EmployeesDto> getEmployeesMoreExperience(){
        
        return employeesDao.getEmployeesMoreExperience();
    }
    
    @GetMapping("/departments/avgsalary")
    private List<DepartmentsAvgSalaryDto> getDepartmentsAvgSalary(){
        
        return departmentsSalary.getDeparmentsAvgSalary();
    }
    
    @GetMapping("/countries")
    private List<EmployeesByCountryDto> getDataCountries(){
        
        return countriesDao.getEmployeesByCountry();
    }
}
