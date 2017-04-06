package com.jlo.weborixas.java.models;

import java.util.ArrayList;

import org.springframework.beans.factory.config.AbstractFactoryBean;

public class XireFactory extends AbstractFactoryBean<Xire>{
	
	
	//TODO refactor to properties 
	public static final Integer  MAXELEM = 4;
	
	
	
private ElementType getElementType(Integer count){
		
		Integer index = count % MAXELEM;	
		return ElementType.values()[index];
	
	}
	
	
private ArrayList<Orixa> generateOrixas(){
		
	
		ArrayList<Orixa> orixas = new ArrayList<Orixa>();
		OrixaType[] orixasType = OrixaType.values();
		
		Integer countElements = MAXELEM;
		Integer countOrixa = 0;
	
		while (countElements > 0 && countOrixa < 16){
			
			Element main = new Element(getElementType(countElements));
			Element second =  new Element(getElementType(countOrixa));
		
			Orixa orixa = new Orixa (orixasType[countOrixa].toString(), main,second);
			orixas.add(orixa);
			countOrixa++;
			if(countOrixa % MAXELEM == 4){
				countElements--;
			}
			
		}
		
		
		return orixas;
		
		
		
	}



@Override
protected Xire createInstance() throws Exception {
	
		Xire xire = new Xire();
		xire.setOrixasRepository(generateOrixas());
		return xire;
	}


@Override
public Class<?> getObjectType() {
	// TODO Auto-generated method stub
	return Xire.class;
} 

	

}

