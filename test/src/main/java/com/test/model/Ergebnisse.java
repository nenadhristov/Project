package com.test.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Ergebnisse")
public class Ergebnisse {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="messwert")
	private double messwert;
	
	@Column(name="einheit")
	private String einheit;
	
	@Column(name="material")
	private String material;
	
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Column(name = "laboreingangsdatum")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Timestamp laboreingangsdatum;
	
	public Timestamp getLaboreingangsdatum() {
		return laboreingangsdatum;
	}

	public void setLaboreingangsdatum(Timestamp laboreingangsdatum) {
		this.laboreingangsdatum = laboreingangsdatum;
	}

	@Column(name="status")
	private String status;
	
	@Column(name="parameter")
	private String parameter;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMesswert() {
		return messwert;
	}

	public void setMesswert(double messwert) {
		this.messwert = messwert;
	}

	public String getEinheit() {
		return einheit;
	}

	public void setEinheit(String einheit) {
		this.einheit = einheit;
	}

	


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	
	
	

	
	
	

}
