package com.jlo.weborixas.java.views;

import com.jlo.weborixas.java.models.Characteristic;

public class CharacteristicView {
	
	private Characteristic characteristic;
	
	private boolean answer = false;
	
	
	public void setAnswer(boolean answer) {
		this.answer = answer;
	}


	public Characteristic getCharacteristic() {
		return characteristic;
	}


	public void setCharacteristic(Characteristic characteristic) {
		this.characteristic = characteristic;
	}


	public boolean isAnswer() {
		return answer;
	}
	
	
	

}
