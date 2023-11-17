package carsalon.service;

import carsalon.dto.ReportDto;
import carsalon.repo.SalesRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class CarService {

	private final SalesRepo repo;

	public Long getSum(LocalDate startDay, LocalDate endDay) {
		return repo.getSumByDay(startDay.minusDays(1L), endDay);
	}

	public List<ReportDto> getReport() {
		return repo.getReportByDay();
	}
}
