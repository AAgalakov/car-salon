package carsalon.repo;

import carsalon.dto.ReportDto;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@AllArgsConstructor
public class SalesRepo {

	private static final String QUERY = """
		SELECT sum(sales.price) FROM sales
		where date > '%s' and date < '%s'
		""";

	private static final String REPORT_QUERY = """
		SELECT m.name AS name, m.phone AS phone, s.price AS price, s.date AS date, s.model AS model, s.count AS count
		FROM sales s
		         JOIN manager m ON m.id = s.manager_id
		ORDER BY date, name, price;
		""";

	private JdbcTemplate jdbcTemplate;

	public List<ReportDto> getReportByDay() {
		return jdbcTemplate.query(REPORT_QUERY, (rs, rowNum) -> ReportDto.builder().price(rs.getInt("price"))
			.carModel(rs.getString("model")).count(rs.getInt("count")).date(rs.getObject("date", LocalDate.class))
			.manager(rs.getString("name")).phone(rs.getString("phone")).build());
	}

	public Long getSumByDay(LocalDate startDate, LocalDate endDate) {

		String formatted = QUERY.formatted(startDate, endDate);
		return jdbcTemplate.queryForObject(formatted, Long.class);
	}
}
