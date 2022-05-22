package myHotel.tecnica.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import myHotel.tecnica.dto.EmployeesDto;
import myHotel.tecnica.dto.EmployeesMaxSalaryDto;
import myHotel.tecnica.model.EmployeesMaxSalaryRowMapper;
import myHotel.tecnica.model.EmployeesRowMapper;

@Repository
public class EmployeesDaoImpl implements EmployeesDao {

    private final JdbcTemplate jdbcTemplate;   
    
    @Autowired
    public EmployeesDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long getEmployeesBySalaryHigh() {
        
        String sql = "select count(*) from employees where salary >= 8000";
        
        return jdbcTemplate.queryForObject(sql, Long.class);
                
    }

    @Override
    public Long getEmployeesBySalaryMedium() {
        
        String sql = "select count(*) from employees where salary BETWEEN 3500 and 7999";
        
        return jdbcTemplate.queryForObject(sql, Long.class);
    }

    @Override
    public Long getEmployeesBySalaryLow() {
        
        String sql = "select count(*) from employees where salary < 3500";
        
        return jdbcTemplate.queryForObject(sql, Long.class);
        
    }

    @Override
    public List<EmployeesMaxSalaryDto> getEmployeesMaxSalaryByDepartments() {
        
        String sql = "select  MAX(SALARY) AS MAX_SALARY, employees.* \r\n"
                + "from employees\r\n"
                + "group by DEPARTMENT_ID";
        
        return jdbcTemplate.query(sql, new EmployeesMaxSalaryRowMapper());
    }

    @Override
    public List<EmployeesDto> getEmployeesMoreExperience() {

        String sql = "select e.* \r\n"
                + "from employees e\r\n"
                + "INNER JOIN jobs j ON e.JOB_ID = j.JOB_ID AND j.JOB_TITLE in (select JOB_TITLE from jobs WHERE LOCATE('Manager', JOB_TITLE) > 0)\r\n"
                + "INNER JOIN job_history j_h ON (j.JOB_ID = j_h.job_id AND j_h.EMPLOYEE_ID in (select EMPLOYEE_ID from job_history where START_DATE < DATE_SUB(CURRENT_DATE , INTERVAL 15 YEAR)))";
        
        return jdbcTemplate.query(sql, new EmployeesRowMapper());
    }

   
    
    

}
