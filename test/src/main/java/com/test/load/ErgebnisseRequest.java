package com.test.load;

import java.sql.Date;
import java.sql.Timestamp;


import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErgebnisseRequest {
	
	@Column(name="material")
	private String Material;
	
	
	@Column(name="laboreingangsdatum")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date Laboreingangsdatum;
	
	public String getMaterial() {
		return Material;
	}

	public void setMaterial(String Material) {
		this.Material = Material;
	}

	public Date getLaboreingangsdatum() {
		return Laboreingangsdatum;
	}

	public void setLaboreingangsdatum(Date Laboreingangsdatum) {
		this.Laboreingangsdatum = Laboreingangsdatum;
	}

	
	
	



}
