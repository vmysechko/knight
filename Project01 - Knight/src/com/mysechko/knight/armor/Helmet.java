package com.mysechko.knight.armor;

import java.util.Random;

public class Helmet extends Armor {
	
	public Helmet(){
		this.element = ArmorElements.Helmet;
		this.name = ArmorElements.Helmet.name();
	}

	@Override
	public void chooseArmorMaterial() {
		/*If new material will be added to the ArmorMAterial class and it is suitable for the <Helmet> 
		 * - value <3> in the row below should be increased accordingly.*/
		int materialNumber = (int) (Math.random()*3);

		// Assign the needed material to the <material> variable
		for (ArmorMaterial material : ArmorMaterial.values()) {
			if (material.ordinal() == materialNumber)
				this.material = material;
		}

	}

}
