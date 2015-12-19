package com.mysechko.knight.armor;

import java.util.Random;

public class Gloves extends Armor {
	
	public Gloves(){
		this.element = ArmorElements.Gloves;
		this.name = ArmorElements.Gloves.name();
	}

	@Override
	public void chooseArmorMaterial() {
		this.material = ArmorMaterial.Leither;
	}
}
