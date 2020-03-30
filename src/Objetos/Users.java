package Objetos;

import java.sql.Date;

public class Users {
	private String name,surname,email,password, province,address,cp,dni;
	private Date birthday;
	private String phoneNumber,language;
	public Users(String name, String surname, String email, String password, String province, String address, String cp,
			String dni, Date birthday, String phoneNumber, String language) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.province = province;
		this.address = address;
		this.cp = cp;
		this.dni = dni;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
		this.language = language;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "Users [name=" + name + ", surname=" + surname + ", email=" + email + ", password=" + password
				+ ", province=" + province + ", address=" + address + ", cp=" + cp + ", dni=" + dni + ", birthday="
				+ birthday + ", phoneNumber=" + phoneNumber + ", language=" + language + "]";
	}
	
}