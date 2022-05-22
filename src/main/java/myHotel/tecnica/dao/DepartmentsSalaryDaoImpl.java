package myHotel.tecnica.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import myHotel.tecnica.dto.DepartmentsAvgSalaryDto;
import myHotel.tecnica.dto.DepartmentsMixDto;
import myHotel.tecnica.model.DepartmentsAvgSalaryRowMapper;
import myHotel.tecnica.model.DepartmentsMixRowMapper;

@Repository
public class DepartmentsSalaryDaoImpl implements DepartmentsSalaryDao {

    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public DepartmentsSalaryDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public List<DepartmentsMixDto> getSalaryByDepartments() {

        String sql ="select d.DEPARTMENT_ID, CASE WHEN  e.salary >= 8000 then \"SEGMENT C\" \r\n"
                + "    WHEN e.salary BETWEEN 3500 and 7999 then \"SEGMENT B\"\r\n"
                + "    ELSE \"SEGMENT A\"\r\n"
                + "    END AS SALARY_GROUP,count(*) as CANTIDAD\r\n"
                + "from departments d LEFT JOIN employees e ON d.DEPARTMENT_ID = e.DEPARTMENT_ID\r\n"
                + "group by 1,2";
        
        return jdbcTemplate.query(sql, new DepartmentsMixRowMapper());
      
    }

    @Override
    public List<DepartmentsAvgSalaryDto> getDeparmentsAvgSalary() {

        String sql = "select AVG(e.SALARY) AS AVG_SALARY, e.DEPARTMENT_ID from employees e "
                + "where e.DEPARTMENT_ID in (select DEPARTMENT_ID from employees group by DEPARTMENT_ID having count(*) > 15) "
                + "group by DEPARTMENT_ID";
        
        return jdbcTemplate.query(sql, new DepartmentsAvgSalaryRowMapper());
    }

}