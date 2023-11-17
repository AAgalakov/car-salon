package carsalon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class SalesManager {

	private final UUID managerId;
	private final String name;
	private final String phone;

}
