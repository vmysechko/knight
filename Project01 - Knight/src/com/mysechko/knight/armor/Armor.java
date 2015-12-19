package com.mysechko.knight.armor;

import java.util.Random;

public abstract class Armor implements Comparable<Armor> {

	protected String name;
	protected int weight;
	protected int price;
	protected int armorImportancy;
	protected ArmorMaterial material;
	protected ArmorElements element;

	public abstract void chooseArmorMaterial();
	
	public void createImportance() {
		this.armorImportancy = element.ordinal() + 1;
	}

	public void createWeight() {
		this.weight = (int) (Math.random() * 10 + 1) + this.element.ordinal();
	}

	/*Armor price for the knight calculation based on <weight> and <importancy>.*/
	public void calculateArmorPrice() {
		if (this.weight != 0) {
			this.price = this.weight * 3 + this.armorImportancy;
		} else {
			System.out.println("Weight and armor importancy should be defined first!");
			return;
		}
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public int getPrice() {
		return price;
	}

	public String getArmorMaterial() {
		return material.name();
	}

	public ArmorElements getElement() {
		return element;
	}

	@Override
	public String toString() {
		String ArmorDescription = new String(this.name.toUpperCase() 
										+ " made from " 
										+ this.material.name().toUpperCase() 
										+ " (weight = "
										+ this.weight 
										+ " kg; price = " 
										+ this.price 
										+ " uah)");
		return ArmorDescription;
	}

	/*
	 * Overrided comparator we need to be able to sort the armor objects, according to their weight, using standard <sort> method
	 */
	@Override
	public int compareTo(Armor o) {
		return this.weight - o.weight;
	}

}
