package org.collector.domain;

import org.collector.presentation.dto.GCD;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CycleInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int sec;
	@Enumerated(EnumType.STRING)
	private GCD gcd;
	private double lat;
	private double lon;
	private int ang;
	private int spd;
	private int sum;
	private int bat;

	public static double convertToSixDecimalPlaces(Double value) {
		return value / 100000.0;
	}
}
