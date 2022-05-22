package myHotel.tecnica.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import myHotel.tecnica.dto.DepartmentsMixDto;

public class DepartmentsMixRowMapper implements RowMapper<DepartmentsMixDto> {

    @Override
    public DepartmentsMixDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        return new DepartmentsMixDto(rs.getBigDecimal("DEPARTMENT_ID"), rs.getString("SALARY_GROUP"), 
                rs.getLong("CANTIDAD"));
    }

}