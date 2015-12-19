package com.mysechko.knight.armor;

public class Leggins extends Armor {
	
	public Leggins(){
		this.element = ArmorElements.Leggins;
		this.name = ArmorElements.Leggins.name();
	}

	@Override
	public void chooseArmorMaterial() {
		this.material = ArmorMaterial.Leither;
	}

}
