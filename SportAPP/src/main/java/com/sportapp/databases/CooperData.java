package com.sportapp.databases;

public class CooperData {
 int edad;
 int malo;
 int medio;
 int bueno;
 int muy_bueno;
 int excelente;
 public CooperData(){
	 
 }
public CooperData(int edad, int malo, int medio, int bueno, int muy_bueno, int excelente) {
	super();
	this.edad = edad;
	this.malo = malo;
	this.medio = medio;
	this.bueno = bueno;
	this.muy_bueno = muy_bueno;
	this.excelente = excelente;
}
public int getEdad() {
	return edad;
}
public void setEdad(int edad) {
	this.edad = edad;
}
public int getMalo() {
	return malo;
}
public void setMalo(int malo) {
	this.malo = malo;
}
public int getMedio() {
	return medio;
}
public void setMedio(int medio) {
	this.medio = medio;
}
public int getBueno() {
	return bueno;
}
public void setBueno(int bueno) {
	this.bueno = bueno;
}
public int getMuy_bueno() {
	return muy_bueno;
}
public void setMuy_bueno(int muy_bueno) {
	this.muy_bueno = muy_bueno;
}
public int getExcelente() {
	return excelente;
}
public void setExcelente(int excelente) {
	this.excelente = excelente;
}
}
