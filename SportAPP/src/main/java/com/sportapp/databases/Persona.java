package com.sportapp.databases;

import java.sql.Date;

public class Persona {
 String nombre;
 String primerApellido;
 String segundoApellido;
 int cedula;
 float altura;
 int telefono;
 String sexo;
 Date fechaNacimiento;
 String nombreUsuario;
 String contrasena;
 String respuesta1;
 String respuesta2;
 String respuesta3;
 public Persona() {
 }
public Persona(String nombre, String primerApellido, String segundoApellido, int cedula, float altura, int telefono,
		String sexo, Date fechaNacimiento, String nombreUsuario, String contrasena, String respuesta1,
		String respuesta2, String respuesta3) {
	super();
	this.nombre = nombre;
	this.primerApellido = primerApellido;
	this.segundoApellido = segundoApellido;
	this.cedula = cedula;
	this.altura = altura;
	this.telefono = telefono;
	this.sexo = sexo;
	this.fechaNacimiento = fechaNacimiento;
	this.nombreUsuario = nombreUsuario;
	this.contrasena = contrasena;
	this.respuesta1 = respuesta1;
	this.respuesta2 = respuesta2;
	this.respuesta3 = respuesta3;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getPrimerApellido() {
	return primerApellido;
}
public void setPrimerApellido(String primerApellido) {
	this.primerApellido = primerApellido;
}
public String getSegundoApellido() {
	return segundoApellido;
}
public void setSegundoApellido(String segundoApellido) {
	this.segundoApellido = segundoApellido;
}
public int getCedula() {
	return cedula;
}
public void setCedula(int cedula) {
	this.cedula = cedula;
}
public float getAltura() {
	return altura;
}
public void setAltura(float altura) {
	this.altura = altura;
}
public int getTelefono() {
	return telefono;
}
public void setTelefono(int telefono) {
	this.telefono = telefono;
}
public String getSexo() {
	return sexo;
}
public void setSexo(String sexo) {
	this.sexo = sexo;
}
public Date getFechaNacimiento() {
	return fechaNacimiento;
}
public void setFechaNacimiento(Date fechaNacimiento) {
	this.fechaNacimiento = fechaNacimiento;
}
public String getNombreUsuario() {
	return nombreUsuario;
}
public void setNombreUsuario(String nombreUsuario) {
	this.nombreUsuario = nombreUsuario;
}
public String getContrasena() {
	return contrasena;
}
public void setContrasena(String contrasena) {
	this.contrasena = contrasena;
}
public String getRespuesta1() {
	return respuesta1;
}
public void setRespuesta1(String respuesta1) {
	this.respuesta1 = respuesta1;
}
public String getRespuesta2() {
	return respuesta2;
}
public void setRespuesta2(String respuesta2) {
	this.respuesta2 = respuesta2;
}
public String getRespuesta3() {
	return respuesta3;
}
public void setRespuesta3(String respuesta3) {
	this.respuesta3 = respuesta3;
}


 
 
 
}
