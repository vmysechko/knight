package com.mysechko.knight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.mysechko.knight.armor.Armor;
import com.mysechko.knight.armor.ArmorElements;
import com.mysechko.knight.armor.ArmorMaker;

public class Knight {
	
	private String name;
	private ArrayList<Armor> armorForKnight = new ArrayList<Armor>();
	
	public Knight(String name){
		this.name = name;
	}
	
	/*Method to equip knight with full package of armor.
	 * First we went through the list of available armors in the enum class ArmorElements,
	 * then we send the position number (ordinal) of each element to the ArmorMaker constructor (Fabric pattern),
	 * so we can receive the complete armor and add it to the List <armorForKnight>*/
	public void createArmorForKnight(){
		for(ArmorElements element: ArmorElements.values()){
			ArmorMaker makeArmor = new ArmorMaker(element.ordinal());
			this.armorForKnight.add(makeArmor.getArmor());
		}
	}

	/*Overrided method to iterate through the List with armor and to print the list in order.*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int i = armorForKnight.size() - 1; i >=0; i--){
			builder.append("\n").append(armorForKnight.get(i).getName().toUpperCase()).append("\n")
					.append("made from ").append(armorForKnight.get(i).getArmorMaterial().toUpperCase()).append("\n")
					.append("(weight = " + armorForKnight.get(i).getWeight() + ";")
					.append(" price = " + armorForKnight.get(i).getPrice() + ")").append("\n");
		}
		return builder.toString();
	}
	
	/*Sort armor elements according to their weight*/
	public String sortAccordingToWeight(){
		Collections.sort(this.armorForKnight);
		StringBuilder sortedCollection = new StringBuilder();
		for(int i = armorForKnight.size() - 1; i >=  0; i--){
			sortedCollection.append((armorForKnight.size() - i))
									.append(" - ")
									.append(armorForKnight.get(i).getElement().name().toUpperCase())
									.append(", weight = ")
									.append(armorForKnight.get(i).getWeight() + "kg")
									.append("\n");
		}
		return sortedCollection.toString();
	}
	
	/*Sort armor elements according to their price in the defined price */
	public String chooseAccordingToPrice(int low, int high){
		int first = low;
		int second = high;
		
		StringBuilder price = new StringBuilder();
				
		int j = 1;
		for(int i = armorForKnight.size() - 1; i >=  0; i--){
			if(armorForKnight.get(i).getPrice() >= first && armorForKnight.get(i).getPrice() <= second){
			price.append(j)
					.append(" - ")
					.append(armorForKnight.get(i).getElement().name().toUpperCase())
					.append(", price = " + armorForKnight.get(i).getPrice() + "uah")
					.append(";\n");
			j++;
			}
		} 
		return price.toString();
	}
}
