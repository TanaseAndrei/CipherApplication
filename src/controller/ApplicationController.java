package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import frame.MyFrame;
import panels.ComboBoxPanel;
import panels.TextPanel;

/**Controller of the entire application.
 * Here is the ActionListener implementation for the ComboBox in the left panel.
 * Here are the ActionListeners implementations for the algorithms.
 * 
 * 
 */
public class ApplicationController{
	
	private MyFrame frame;
	@SuppressWarnings("unused")
	private ComboBoxPanel leftPanel;
	@SuppressWarnings("unused")
	private TextPanel rightPanel;
	
	public ApplicationController(MyFrame frame, ComboBoxPanel leftPanel, TextPanel rightPanel) {
		
		this.frame = frame;
		this.leftPanel = leftPanel;
		this.rightPanel = rightPanel;
		this.frame.addComboBoxListener(new ComboBoxListener());
		
	}
	
	 class ComboBoxListener implements ActionListener {
			
			@SuppressWarnings("rawtypes")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Take the event's source and cast to combobox
				 */
				JComboBox c = (JComboBox) e.getSource();
				
				/*
				 * Get the selected index's name
				 * Based on the name, the function returns an algorithm
				 * Acts like a factory design pattern
				 */
				String selected = c.getSelectedItem().toString();
				
				if(selected.equalsIgnoreCase("Caesar's Cipher")) {
					frame.removeExecuteButtonListener();
					frame.addExecuteButtonListener(new CaesarsCipher());
					frame.showOffset();
					frame.updateLeftPanel();
				} else if(selected.equalsIgnoreCase("ROT13")) {
					frame.removeExecuteButtonListener();
					frame.addExecuteButtonListener(new ROT13());
					frame.hideOffset();
					frame.updateLeftPanel();
				} else if(selected.equalsIgnoreCase("Beaufort Cipher")) {
					frame.removeExecuteButtonListener();
					frame.addExecuteButtonListener(new BeaufortCipher());
					frame.hideOffset();
					frame.updateLeftPanel();
				} else if(selected.equalsIgnoreCase("Autokey Cipher")) {
					frame.removeExecuteButtonListener();
					frame.addExecuteButtonListener(new AutokeyCipher());
					frame.hideOffset();
					frame.updateLeftPanel();
				}
				
			}
			
		}
	 
	 class CaesarsCipher implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 
			 try {
				 int offset = Integer.parseInt(frame.getOffset());
				 char []text = frame.getInputText().toCharArray();
					
					for(int i = 0 ; i < text.length ; i++) {
						if(Character.isUpperCase(text[i])) {
							text[i] = (char)(((int)text[i] + offset - 65) % 26 + 65);
						} else if(Character.isLowerCase(text[i])) {
							text[i] = (char)(((int)text[i] + offset - 97) % 26 + 97);
						}
					}
					frame.setOutputText(new String(text));
			 } catch(NumberFormatException exception) {
				 frame.setOutputText("Incorrect value for offset, need a numerical value.");
			 }
			 				
		 }
	 }
	 
	 class ROT13 implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
			 
				char []text = frame.getInputText().toCharArray();
				
				for(int i = 0 ; i < text.length ; i++) {
					if(Character.isUpperCase(text[i])) {
						text[i] = (char)(((int)text[i] + 13 - 65) % 26 + 65);
					} else if(Character.isLowerCase(text[i])) {
						text[i] = (char)(((int)text[i] + 13 - 97) % 26 + 97);
					}
				}
				
				frame.setOutputText(new String(text));
		 }
	 }
	 
	 class BeaufortCipher implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 System.out.println("b");
		 }
	 }
	 
	 class AutokeyCipher implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 System.out.println("a");
		 }
	 }
	
}


