package com.jlo.weborixas.java.models;


import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;


public class Xire {
	
	
	private ArrayList<Orixa> orixasRepository;

	public ArrayList<Orixa> getOrixasRepository() {
		return orixasRepository;
	}

	public void setOrixasRepository(ArrayList<Orixa> orixasRepository) {
		this.orixasRepository = orixasRepository;
	}
	
	
	
	public String toString() {
		//return orixasRepository.stream().map(x -> x.getName()).collect(Collectors.joining(" ")));
		StringBuilder list = new StringBuilder();
		 orixasRepository.forEach(
		k -> {
			 list.append(k.getName() +" ");
			 });
		return list.toString();
		
	}

	
	

}
