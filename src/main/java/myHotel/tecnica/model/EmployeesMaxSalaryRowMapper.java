package myHotel.tecnica.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import myHotel.tecnica.dto.EmployeesMaxSalaryDto;

public class EmployeesMaxSalaryRowMapper implements RowMapper<EmployeesMaxSalaryDto>{

    @Override
    public EmployeesMaxSalaryDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        return new EmployeesMaxSalaryDto(rs.getBigDecimal("MAX_SALARY"), rs.getBigDecimal("EMPLOYEE_ID"), 
                rs.getString("JOB_ID"), rs.getBigDecimal("DEPARTMENT_ID"));
    }

}
