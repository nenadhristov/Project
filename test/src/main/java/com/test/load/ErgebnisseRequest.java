package com.test.load;

import java.sql.Timestamp;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErgebnisseRequest {
	
	@Column(name="material")
	private String material;
	
	
	

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}


}
