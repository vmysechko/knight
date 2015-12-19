package com.mysechko.knight;

import java.awt.SecondaryLoop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.SwingUtilities;

import com.mysechko.knight.gui.KnightFirstScreen;

public class AppKnightGuild {

	public static void main(String[] args) throws IOException {
		
		/* This section describe the code to be run for the console.
		 * Updated version of the program works with user interface created with <javax.swing.*> library.
		
		
		System.out.println("Do you want to create a knight and dressed him with the best armor? \n(type 'yes' or 'no')");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String creationCommand = reader.readLine();

		if (creationCommand.equalsIgnoreCase("yes")) {

			System.out.println("\nWrite a name for the mighty KNIGHT, my friend: ");
			String knightsName = reader.readLine();

			Knight knight = new Knight(knightsName);
			knight.createArmorForKnight();
			System.out.println(knight.toString());

			System.out.println("Do you want to sort the armor items according to their weight:\n(type 'yes' or 'no')");
			String armorWeight = reader.readLine();

			if (armorWeight.equalsIgnoreCase("yes")) {
				knight.sortAccordingToWeight();
			} else {
				System.out.println("\nWe will skip the weight sorting and continue our game!");
			}

			System.out.println("\n Define the price range, for which you want to choose the armor items:\n(type two numbers, separate with 'Enter' button)");
			String first = reader.readLine();
			String second = reader.readLine();

			int firstPrice = Integer.parseInt(first);
			int secondPrice = Integer.parseInt(second);

			knight.chooseAccordingToPrice(firstPrice, secondPrice);

		} else {
			System.out.println("Thank you for playing and see you next time :-)!");
		}
		*/
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new KnightFirstScreen().createFirstScreen();
			}
		});

	}
}
