package myHotel.tecnica.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import myHotel.tecnica.dto.EmployeesByCountryDto;

public class CountriesRowMapper implements RowMapper<EmployeesByCountryDto> {
    
    @Override
    public EmployeesByCountryDto mapRow(ResultSet rs, int rowNum) throws SQLException{
        
        return new EmployeesByCountryDto(rs.getString("COUNTRY_ID"), rs.getString("COUNTRY_NAME"), rs.getBigDecimal("REGION_ID"), 
                rs.getBigDecimal("ANTIQUITY_AVG_YEARS"), rs.getBigDecimal("MAX_SALARY"), rs.getBigDecimal("MIN_SALARY"), 
                rs.getInt("EMPLOYEE_QUANTITY"));
    }
    
}
