package com.mysechko.knight.gui;

import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.nio.channels.ShutdownChannelGroupException;

import javax.swing.*;

import com.mysechko.knight.Knight;

import static javax.swing.GroupLayout.Alignment.*;

/*GUI for the second screen of the <Knight> game.*/
public class KnightSecondScreen {

	JFrame secondScreenFrame;
	JPanel buttonsPanel;
	PicturePanel picturePanel;
	JLabel knightsNameRequestLabel;
	JTextField knightsNameTextField;
	JButton createKnightButton;
	JLabel knightArmorListLabel;
	JTextArea knightArmorList;
	JButton armorWeightSortButton;
	JTextArea armorWeightSortList;
	JButton armorPricetSortButton;
	JTextArea armorPricetSortList;	
	JLabel knightsNameLabel;
	Knight knight;
	Font fontForTextArea = new Font("TimesNewRoman", Font.LAYOUT_LEFT_TO_RIGHT, 12);
	Font fontForShieldLabel = new Font("Arial", Font.BOLD, 16);
	
	/*Separate method to create text areas with same standard parameters*/
	private JTextArea createTextArea(JTextArea textArea){
		textArea = new JTextArea(15, 17);
		textArea.setFont(fontForTextArea);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEnabled(false);
		textArea.setDisabledTextColor(Color.BLACK);
		return textArea;
	}

	public void createSecondScreen() {

		secondScreenFrame = new JFrame("Knight App") ;
		knightsNameRequestLabel = new JLabel("Enter name for the knight!");
		knightsNameTextField = new JTextField(15);
		knightsNameTextField.setFocusable(true);
		knightsNameTextField.setFont(new Font("Verdana", Font.BOLD, 12));

		picturePanel = new PicturePanel();
		knightsNameLabel = new JLabel();
		picturePanel.add(Box.createRigidArea(new Dimension(10, 475)));
		picturePanel.add(knightsNameLabel);
		picturePanel.add(Box.createRigidArea(new Dimension(205, 10)));
		
		createKnightButton = new JButton("Create Knight!");
		createKnightButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			
				if(!knightsNameTextField.getText().isEmpty()){
					knight = new Knight(knightsNameTextField.getText());					
				} else {
					knight = new Knight("DEFAULT");
				}
				
				try{
				knight.createArmorForKnight();
				} catch (Exception eNUL) {
					System.out.println("Message:" + eNUL.getMessage());
					eNUL.printStackTrace();
				}
				knightArmorList.setText(knight.toString());
				armorWeightSortButton.setEnabled(true);
				armorPricetSortButton.setEnabled(true);
				knightsNameLabel.setText(knightsNameTextField.getText());
				knightsNameLabel.setFont(fontForShieldLabel);
			}
		});
		
		buttonsPanel = new JPanel();
		knightArmorListLabel = new JLabel("Knight`s armor list:");
		
		/*Text area where the list of armors will be shown*/
		knightArmorList = createTextArea(knightArmorList);	
		JScrollPane scrollPaneArmor = new JScrollPane(knightArmorList);
		
		/*Button and text area to sort armor according to weight*/
		armorWeightSortButton = new JButton("Weight sort");
		armorWeightSortButton.setEnabled(false);
		armorWeightSortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				armorWeightSortList.setText(knight.sortAccordingToWeight());
			}
		});
		
		armorWeightSortList = createTextArea(armorWeightSortList);
		JScrollPane scrollPaneWeight = new JScrollPane(armorWeightSortList);
		
		/*Button and text area to sort armor according to price*/
		armorPricetSortButton = new JButton("Price sort");
		armorPricetSortButton.setEnabled(false);
		armorPricetSortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				armorPricetSortList.setText(knight.chooseAccordingToPrice(0, Integer.MAX_VALUE));
			}
		});
		
		armorPricetSortList = createTextArea(armorPricetSortList);
		JScrollPane scrollPanePrice = new JScrollPane(armorPricetSortList);
		
		/*Creating menu bar*/
		JMenuBar knightMenuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu help = new JMenu("Help");

		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				secondScreenFrame.dispatchEvent(new WindowEvent(secondScreenFrame, WindowEvent.WINDOW_CLOSING));	
			}
		});

		JMenuItem aboutApp = new JMenuItem("About Knight App");
		aboutApp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*Text for the <About> screen body*/
				new KnightFirstScreen().createAboutScreen();
			}
		});
		help.add(aboutApp);

		file.add(exit);
		knightMenuBar.add(file);
		knightMenuBar.add(Box.createHorizontalGlue());
		knightMenuBar.add(help);
		
		secondScreenFrame.setJMenuBar(knightMenuBar);
		
		/*Set minimum size for the second screen*/
		secondScreenFrame.setMinimumSize(new Dimension(975, 515));

		GroupLayout layout = new GroupLayout(secondScreenFrame.getContentPane());
		secondScreenFrame.getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		/*Use of GroupLayout - placing the elements horizontal and vertical*/
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(CENTER)
					.addComponent(knightsNameRequestLabel)
					.addComponent(knightsNameTextField)
					.addComponent(createKnightButton)
					.addComponent(knightArmorListLabel)
					.addComponent(scrollPaneArmor))
				.addGroup(layout.createParallelGroup(CENTER)
						.addComponent(picturePanel))
				.addGroup(layout.createParallelGroup(CENTER)
					.addComponent(armorWeightSortButton)
					.addComponent(scrollPaneWeight))
				.addGroup(layout.createParallelGroup(CENTER)
					.addComponent(armorPricetSortButton)
					.addComponent(scrollPanePrice)));
		
		layout.linkSize(SwingConstants.HORIZONTAL,	knightsNameTextField, scrollPaneArmor, scrollPaneWeight, scrollPanePrice);
		layout.linkSize(SwingConstants.VERTICAL, scrollPaneArmor);
		layout.linkSize(SwingConstants.VERTICAL, scrollPaneWeight);
		layout.linkSize(SwingConstants.VERTICAL, scrollPanePrice);
		layout.linkSize(SwingConstants.VERTICAL,createKnightButton, knightsNameTextField, armorWeightSortButton, armorPricetSortButton); 
		
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(BASELINE)
						.addGroup(layout.createSequentialGroup()
								.addComponent(knightsNameRequestLabel)
								.addComponent(knightsNameTextField)
								.addComponent(createKnightButton)
								.addComponent(knightArmorListLabel)
								.addComponent(scrollPaneArmor))
						.addGroup(layout.createSequentialGroup()
								.addComponent(picturePanel))
						.addGroup(layout.createSequentialGroup()
								.addComponent(armorWeightSortButton)
								.addComponent(scrollPaneWeight))
						.addGroup(layout.createSequentialGroup()
								.addComponent(armorPricetSortButton)
								.addComponent(scrollPanePrice))));
		
		secondScreenFrame.setLocationRelativeTo(null);
		secondScreenFrame.setVisible(true);
		secondScreenFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
