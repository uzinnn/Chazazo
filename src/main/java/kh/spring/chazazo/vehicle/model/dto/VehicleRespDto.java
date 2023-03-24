package kh.spring.chazazo.vehicle.model.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Data
public class VehicleRespDto {
	// 자동차 검색용 dto
	
	public int idx;
	public String model;
	public int year;
	public int price;
	public String image;
	public String maker;
	public int locationIdx;
	public int fueltypeIdx;
	public int cartypeIdx;
	
}
