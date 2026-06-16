package com.tka.entity;

public class Player {

	private String pName;
	private int jerseyNo;
	private String tName;
	private int run;
	private int wicket;
	
	public Player() {}

	public Player(String pName, int jerseyNo, String tName, int run, int wicket) {
		super();
		this.pName = pName;
		this.jerseyNo = jerseyNo;
		this.tName = tName;
		this.run = run;
		this.wicket = wicket;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getJerseyNo() {
		return jerseyNo;
	}

	public void setJerseyNo(int jerseyNo) {
		this.jerseyNo = jerseyNo;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public int getRun() {
		return run;
	}

	public void setRun(int run) {
		this.run = run;
	}

	public int getWicket() {
		return wicket;
	}

	public void setWicket(int wicket) {
		this.wicket = wicket;
	}

	@Override
	public String toString() {
		return "Player [pName=" + pName + ", jerseyNo=" + jerseyNo + "]";
	}
	
}