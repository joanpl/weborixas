package com.jlo.weborixas.java.models;

public class Element {
	
	private  String name;
	private ElementType type;
	
	
	public Element(String name, ElementType type){
		this.setName(name);
		this.setType(type);
	}
	
	
	public Element(ElementType type){
		
		switch(type){
			case FIRE:
				this.setName(XireConstants.FIRE);
				this.setType(type);
				break;
		
			case EARTH:
				this.setName(XireConstants.EARTH);
				this.setType(type);
				break;
		
			case WATER:
				this.setName(XireConstants.WATER);
				this.setType(type);
				break;
		
			case AIR:
				this.setName(XireConstants.AIR);
				this.setType(type);
				break;
			default: // in case the element isn't identified. Should it just throw an exception? //TOTHINK
				this.setName(XireConstants.FIRE);
				this.setType(type);
				break;	
			}
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ElementType getType() {
		return type;
	}


	public void setType(ElementType type) {
		this.type = type;
	}

		
	
	

}


