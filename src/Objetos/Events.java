package Objetos;

import java.sql.Date;

public class Events {
	private String name;
	private Boolean available;
	private String depCity, depCountry;
	private Date depDate;
	private String aCity, aCountry;
	private Date aDate;
	private String language;
	private int amountPeople;
	private String usersEmail;
	public Events() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Events(String name, Boolean available, String depCity, String depCountry, Date depDate, String aCity,
			String aCountry, Date aDate, String language, int amountPeople, String usersEmail) {
		super();
		this.name = name;
		this.available = available;
		this.depCity = depCity;
		this.depCountry = depCountry;
		this.depDate = depDate;
		this.aCity = aCity;
		this.aCountry = aCountry;
		this.aDate = aDate;
		this.language = language;
		this.amountPeople = amountPeople;
		this.usersEmail = usersEmail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public String getDepCity() {
		return depCity;
	}
	public void setDepCity(String depCity) {
		this.depCity = depCity;
	}
	public String getDepCountry() {
		return depCountry;
	}
	public void setDepCountry(String depCountry) {
		this.depCountry = depCountry;
	}
	public Date getDepDate() {
		return depDate;
	}
	public void setDepDate(Date depDate) {
		this.depDate = depDate;
	}
	public String getaCity() {
		return aCity;
	}
	public void setaCity(String aCity) {
		this.aCity = aCity;
	}
	public String getaCountry() {
		return aCountry;
	}
	public void setaCountry(String aCountry) {
		this.aCountry = aCountry;
	}
	public Date getaDate() {
		return aDate;
	}
	public void setaDate(Date aDate) {
		this.aDate = aDate;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getAmountPeople() {
		return amountPeople;
	}
	public void setAmountPeople(int amountPeople) {
		this.amountPeople = amountPeople;
	}
	public String getUsersEmail() {
		return usersEmail;
	}
	public void setUsersEmail(String usersEmail) {
		this.usersEmail = usersEmail;
	}
	@Override
	public String toString() {
		return "Events [name=" + name + ", available=" + available + ", depCity=" + depCity + ", depCountry="
				+ depCountry + ", depDate=" + depDate + ", aCity=" + aCity + ", aCountry=" + aCountry + ", aDate="
				+ aDate + ", language=" + language + ", amountPeople=" + amountPeople + ", usersEmail=" + usersEmail
				+ "]";
	}
	
}
