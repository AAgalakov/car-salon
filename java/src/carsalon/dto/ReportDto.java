package carsalon.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ReportDto {

	private String manager;
	private String phone;
	private int price;
	private LocalDate date;
	private String carModel;
	private int count;
}
