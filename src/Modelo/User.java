package Modelo;

public class User {
	
	/* 1. cuenta con tres atributos de tipo String: 
	 * username, password y fullName. Cree los 
	 * getters/setters y constructor con parámetros 
	 * username y password
	 * */
	private String username;
	private String password;
	private String fullName;

public User(String username, String password) {
	this.username = username;
	this.password = password;
}

public String getUsername() {
	return username;
}

public String getPassword() {
	return password;
}

public String getFullName() {
	return fullName;
}

public void setUsername(String username) {
	this.username = username;
}

public void setPassword(String password) {
	this.password = password;
}

public void setFullName(String fullName) {
	this.fullName = fullName;
}
}

