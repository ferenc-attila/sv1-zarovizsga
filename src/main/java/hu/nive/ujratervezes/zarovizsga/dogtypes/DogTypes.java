package hu.nive.ujratervezes.zarovizsga.dogtypes;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class DogTypes {

    private JdbcTemplate jdbcTemplate;

    public DogTypes(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> getDogsByCountry(String country) {
        return jdbcTemplate.query("SELECT name FROM dog_types WHERE country = ?",
                (rs, rowNum) -> rs.getString("name").toLowerCase(),
                country.toUpperCase());
    }
}
