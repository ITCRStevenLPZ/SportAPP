package com.sportapp.databases;

import java.sql.Date;

public class Pesos {
	int ID;
	Date fecha;
	float peso;
	String descripcion;
	
	public Pesos() {
	}
	
	public Pesos(int ID, Date fecha, float peso, String descripcion) {
		this.ID = ID;
		this.fecha = fecha;
		this.peso = peso;
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
