package com.mysechko.knight.gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PicturePanel extends JPanel {

	/*We will use this method to draw  */
	@Override
	protected void paintComponent(Graphics g) {
		Image knightPicture = new ImageIcon(getClass().getResource("/knight.jpg")).getImage();
		g.drawImage(knightPicture, 3, 3, this);
	}
	
	

}
