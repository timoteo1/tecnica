package myHotel.tecnica.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import myHotel.tecnica.dto.EmployeesByCountryDto;
import myHotel.tecnica.model.CountriesRowMapper;

@Repository
public class CountriesDaoImpl implements CountriesDao{
    
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public CountriesDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<EmployeesByCountryDto> getEmployeesByCountry() {
        
        String sql = "select c.*, \r\n"
                + "        if ( avg(TIMESTAMPDIFF(YEAR, j_h.START_DATE, j_h.END_DATE)) is null, 0, avg(TIMESTAMPDIFF(YEAR, j_h.START_DATE, j_h.END_DATE))) AS ANTIQUITY_AVG_YEARS,\r\n"
                + "        if(MAX(e.SALARY) is null, 0, MAX(e.SALARY)) AS MAX_SALARY,\r\n"
                + "        if(MIN(e.SALARY) is null, 0, MIN(e.SALARY)) AS MIN_SALARY,\r\n"
                + "        count(e.EMPLOYEE_ID) AS EMPLOYEE_QUANTITY\r\n"
                + "     from countries c \r\n"
                + "    left join locations l ON c.COUNTRY_ID = l.COUNTRY_ID\r\n"
                + "    left join departments d ON l.LOCATION_ID = d.LOCATION_ID\r\n"
                + "    left join employees e ON e.DEPARTMENT_ID = d.DEPARTMENT_ID\r\n"
                + "    left join job_history j_h ON e.EMPLOYEE_ID = j_h.EMPLOYEE_ID \r\n"
                + "    group by c.COUNTRY_ID\r\n"
                + "    order by ANTIQUITY_AVG_YEARS desc";
        return jdbcTemplate.query(sql, new CountriesRowMapper());
    }
}
