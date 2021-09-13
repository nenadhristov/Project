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
@Table(name = "Ergebnisse")
public class Ergebnisse{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "messwert")
	private double Messwert;
	
	@Column(name = "einheit")
	private String Einheit;
	
	@Column(name = "material")
	private String Material;
	
	@Column(name = "laboreingangsdatum")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Timestamp Laboreingangsdatum;
	
	@Column(name = "status")
	private String Status;
	
	@Column(name = "parameter")
	private String Parameter;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMesswert() {
		return Messwert;
	}

	public void setMesswert(double Messwert) {
		this.Messwert = Messwert;
	}

	public String getEinheit() {
		return Einheit;
	}

	public void setEinheit(String Einheit) {
		this.Einheit = Einheit;
	}

	public String getMaterial() {
		return Material;
	}

	public void setMaterial(String Material) {
		this.Material = Material;
	}

	public Timestamp getLaboreingangsdatum() {
		return Laboreingangsdatum;
	}

	public void setLaboreingangsdatum(Timestamp Laboreingangsdatum) {
		this.Laboreingangsdatum = Laboreingangsdatum;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String Status) {
		this.Status = Status;
	}

	public String getParameter() {
		return Parameter;
	}

	public void setParameter(String Parameter) {
		this.Parameter = Parameter;
	}
	
	
	
}
