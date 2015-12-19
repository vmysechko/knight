package com.mysechko.knight.armor;

public class Pants extends Armor {
	
	public Pants(){
		this.element = ArmorElements.Pants;
		this.name = ArmorElements.Pants.name();
	}

	@Override
	public void chooseArmorMaterial() {
		this.material = ArmorMaterial.Leither;
	}

}
