package myHotel.tecnica.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import myHotel.tecnica.dto.DepartmentsAvgSalaryDto;

public class DepartmentsAvgSalaryRowMapper implements RowMapper<DepartmentsAvgSalaryDto> {

    @Override
    public DepartmentsAvgSalaryDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        return new DepartmentsAvgSalaryDto(rs.getBigDecimal("AVG_SALARY"), rs.getBigDecimal("DEPARTMENT_ID"));
    }
    
    

}
