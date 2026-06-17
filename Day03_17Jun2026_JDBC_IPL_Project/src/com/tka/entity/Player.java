package com.tka.entity;

public class Player {
	private int id;
	private String pName;
	private int jerseyNo;
	private String tName;
	private int run;
	private int wicket;
	private String role;
	private String country;
	private double strikeRate;
	private double economy;
	
	public Player() {}

	public Player(int id, String pName, int jerseyNo, String tName, int run, int wicket, 
	              String role, String country, double strikeRate, double economy) {
		this.id = id;
		this.pName = pName;
		this.jerseyNo = jerseyNo;
		this.tName = tName;
		this.run = run;
		this.wicket = wicket;
		this.role = role;
		this.country = country;
		this.strikeRate = strikeRate;
		this.economy = economy;
	}

	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getpName() { return pName; }
	public void setpName(String pName) { this.pName = pName; }
	public int getJerseyNo() { return jerseyNo; }
	public void setJerseyNo(int jerseyNo) { this.jerseyNo = jerseyNo; }
	public String gettName() { return tName; }
	public void settName(String tName) { this.tName = tName; }
	public int getRun() { return run; }
	public void setRun(int run) { this.run = run; }
	public int getWicket() { return wicket; }
	public void setWicket(int wicket) { this.wicket = wicket; }
	public String getRole() { return role; }
	public void setRole(String role) { this.role = role; }
	public String getCountry() { return country; }
	public void setCountry(String country) { this.country = country; }
	public double getStrikeRate() { return strikeRate; }
	public void setStrikeRate(double strikeRate) { this.strikeRate = strikeRate; }
	public double getEconomy() { return economy; }
	public void setEconomy(double economy) { this.economy = economy; }

	@Override
	public String toString() {
		return "Player [id=" + id + ", pName=" + pName + ", jerseyNo=" + jerseyNo + ", tName=" + tName + ", run=" + run
				+ ", wicket=" + wicket + ", role=" + role + ", country=" + country + ", strikeRate=" + strikeRate
				+ ", economy=" + economy + "]";
	}
	
}