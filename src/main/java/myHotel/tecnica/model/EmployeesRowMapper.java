package myHotel.tecnica.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import myHotel.tecnica.dto.EmployeesDto;

public class EmployeesRowMapper implements RowMapper<EmployeesDto> {

    @Override
    public EmployeesDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        EmployeesDto emp = new EmployeesDto();
        
        emp.setEmployeeId(rs.getBigDecimal("EMPLOYEE_ID"));
        emp.setFirstName(rs.getString("FIRST_NAME"));
        emp.setLastName(rs.getString("LAST_NAME"));
        emp.setEmail(rs.getString("EMAIL"));
        emp.setPhoneNumber(rs.getString("PHONE_NUMBER"));
        emp.setHireDate(rs.getDate("HIRE_DATE"));
        emp.setJobId(rs.getString("JOB_ID"));
        emp.setSalary(rs.getBigDecimal("SALARY"));
        emp.setCommisionPct(rs.getBigDecimal("COMMISSION_PCT"));
        emp.setManagerId(rs.getBigDecimal("MANAGER_ID"));
        emp.setDepartmentId(rs.getBigDecimal("DEPARTMENT_ID"));
        
        return emp;
    }
    
}
