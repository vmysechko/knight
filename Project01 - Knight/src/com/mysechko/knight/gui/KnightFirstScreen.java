package com.mysechko.knight.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class KnightFirstScreen {

	JFrame firstScreenFrame;
	JPanel buttonsPanel;
	JLabel greetingsLabel;
	JButton buttonPlay;
	JButton buttonExit;
	
	public void createAboutScreen(){
		/*Text for the <About> screen body*/
		JPanel panel = new JPanel();
		JLabel aboutLabel01 = new JLabel("Knight App.");
		aboutLabel01.setAlignmentX(Component.CENTER_ALIGNMENT);
		aboutLabel01.setAlignmentY(Component.CENTER_ALIGNMENT);
		JLabel aboutLabel02 = new JLabel("First independent app created by Vitaliy Mysechko.");
		aboutLabel02.setAlignmentX(Component.CENTER_ALIGNMENT);
		aboutLabel02.setAlignmentY(Component.CENTER_ALIGNMENT);
		JLabel aboutLabel03 = new JLabel("All rights reserved.");
		aboutLabel03.setAlignmentX(Component.CENTER_ALIGNMENT);
		aboutLabel03.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(aboutLabel01);
		panel.add(aboutLabel02);
		panel.add(aboutLabel03);
		
		JOptionPane.showMessageDialog(null, panel, "About Knight App", JOptionPane.PLAIN_MESSAGE);
	}

	public void createFirstScreen() {
		firstScreenFrame = new JFrame("Knight app");
		firstScreenFrame.setMinimumSize(new Dimension(500, 250));
		firstScreenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		firstScreenFrame.getContentPane().setLayout(new BoxLayout(firstScreenFrame.getContentPane(), BoxLayout.PAGE_AXIS));

		JMenuBar knightMenuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu help = new JMenu("Help");

		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			/* Overriden method will close the application if somebody click on the Exit button */
			@Override
			public void actionPerformed(ActionEvent e) {
				firstScreenFrame.dispatchEvent(new WindowEvent(firstScreenFrame, WindowEvent.WINDOW_CLOSING));
			}
		});

		JMenuItem aboutApp = new JMenuItem("About Knight App");
		aboutApp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createAboutScreen();
			}
		});
		help.add(aboutApp);

		file.add(exit);
		knightMenuBar.add(file);
		knightMenuBar.add(Box.createHorizontalGlue());
		knightMenuBar.add(help);

		firstScreenFrame.setJMenuBar(knightMenuBar);

		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		greetingsLabel = new JLabel("Create knight - Play the game!");
		Font fontGreetingsLabel = new Font("Verdana", Font.BOLD, 16);
		greetingsLabel.setFont(fontGreetingsLabel);
		greetingsLabel.setBackground(Color.WHITE);
		greetingsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		greetingsLabel.setAlignmentY(Component.CENTER_ALIGNMENT);

		buttonPlay = new JButton("PLAY");
		buttonPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/* if somebody pushes button "Play" - create second screen with knight */
				new KnightSecondScreen().createSecondScreen();;
				firstScreenFrame.dispatchEvent(new WindowEvent(firstScreenFrame, WindowEvent.WINDOW_CLOSED));
			}
		});

		buttonExit = new JButton("EXIT");
		buttonExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				firstScreenFrame.dispatchEvent(new WindowEvent(firstScreenFrame, WindowEvent.WINDOW_CLOSING));
			}
		});

		buttonsPanel.add(buttonPlay);
		buttonsPanel.add(Box.createRigidArea(new Dimension(50, 0)));
		buttonsPanel.add(buttonExit);

		/* 
		 * Centers the application window in the center of the screen *
		 */		
		firstScreenFrame.setLocationRelativeTo(null);

		/*
		 * Two times we add VerticalGlue to CENTER the elements and make them stay in the CENTER even when size of the frame is changed
		 */
		firstScreenFrame.getContentPane().add(Box.createVerticalGlue());
		firstScreenFrame.getContentPane().add(greetingsLabel);
		firstScreenFrame.getContentPane().add(Box.createRigidArea(new Dimension(0, 35)));
		firstScreenFrame.getContentPane().add(buttonsPanel);
		firstScreenFrame.getContentPane().add(Box.createVerticalGlue());
		firstScreenFrame.setVisible(true);
	}
}
