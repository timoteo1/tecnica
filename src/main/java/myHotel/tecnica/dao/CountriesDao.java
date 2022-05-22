package myHotel.tecnica.dao;

import java.util.List;

import myHotel.tecnica.dto.EmployeesByCountryDto;

public interface CountriesDao {
    
    List<EmployeesByCountryDto> getEmployeesByCountry();
}
