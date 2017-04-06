package com.jlo.weborixas.java.models;

public class Orixa {
	
	
	//private final long id; //check JPA
	
	private final String name;
	private final Element main;
	private final Element second;
	
	
	
	public Orixa(String name, Element main, Element second){
		this.name = name;
		this.main= main;
		this.second= second;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public Element getSecond() {
		return second;
	}

	public Element getMain() {
		return main;
	}
	
	
	

}
