package com.mysechko.knight.armor;

public class Boots extends Armor {
	
	public Boots(){
		this.element = ArmorElements.Boots;
		this.name = ArmorElements.Boots.name();
	}

	@Override
	public void chooseArmorMaterial() {
		this.material = ArmorMaterial.Leither;
	}

}
