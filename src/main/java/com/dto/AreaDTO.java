package com.dto;

public class AreaDTO {

	private Integer  id;
	private String areaName;
	private Integer density;

	public AreaDTO(Integer id, String areaName,Integer density) {
		super();
		this.id = id;
		this.areaName = areaName;
		this.density=density;
	}

	public AreaDTO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Integer getDensity() {
		return density;
	}

	public void setDensity(Integer density) {
		this.density = density;
	}

	

}
