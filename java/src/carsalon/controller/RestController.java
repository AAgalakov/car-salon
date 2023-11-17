package carsalon.controller;

import carsalon.dto.ReportDto;
import carsalon.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class RestController {

	private final CarService service;

	@GetMapping("/sumByDay")
	public ResponseEntity<Long> getSum(@RequestParam String startDay, @RequestParam String endDay){
		LocalDate start = LocalDate.parse(startDay);
		LocalDate end = LocalDate.parse(endDay);
		return ResponseEntity.of(Optional.of(service.getSum(start, end)));
	}

	@GetMapping("/report")
	public ResponseEntity<List<ReportDto>> getSales(){
		return ResponseEntity.ok(service.getReport());
	}
}
