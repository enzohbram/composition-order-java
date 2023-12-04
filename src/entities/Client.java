package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {

	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private String name;
	private String email;
	private LocalDate BirthDate;
	
	public Client(String name, String email, LocalDate bd) {
		this.name = name;
		this.email = email;
		BirthDate = bd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		BirthDate = birthDate;
	}
	
	public String toString() {
		return name + " (" + BirthDate.format(fmt) + ") - " + email;
 	}
}
