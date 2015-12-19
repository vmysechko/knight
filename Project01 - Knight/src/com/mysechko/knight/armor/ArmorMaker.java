package com.mysechko.knight.armor;

public class ArmorMaker {

	private Armor armor;

	public ArmorMaker(int value) {
		this.armor = createArmor(value);
	}

	private Armor createArmor(int value) {

		/*Thanks to the Fabric pattern we can create any type of armor, depending of our need and only in one place*/
		if (value == 0) {
			armor = new Gloves();
		} else if (value == 1) {
			armor = new Boots();
		} else if (value == 2) {
			armor = new Pants();
		} else if (value == 3) {
			armor = new Leggins();
		} else if (value == 4) {
			armor = new Breastplate();
		} else if (value == 5) {
			armor = new ChainArmor();
		} else if (value == 6) {
			armor = new Helmet();
		}
		
		armor.chooseArmorMaterial();
		armor.createImportance();
		armor.createWeight();
		armor.calculateArmorPrice();

		return armor;
	}

	public Armor getArmor() {
		return armor;
	}
	
}
