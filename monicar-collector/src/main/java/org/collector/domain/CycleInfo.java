package org.collector.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CycleInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String sec;
	private String gcd;
	private String lat;
	private String lon;
	private String ang;
	private String spd;
	private String sum;
	private String bat;

	public CycleInfo(String sec, String gcd, String lat, String lon, String ang, String spd, String sum, String bat) {
		this.sec = sec;
		this.gcd = gcd;
		this.lat = lat;
		this.lon = lon;
		this.ang = ang;
		this.spd = spd;
		this.sum = sum;
		this.bat = bat;
	}
}
