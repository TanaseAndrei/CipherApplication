package main;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.ApplicationController;
import frame.MyFrame;
import panels.ComboBoxPanel;
import panels.TextPanel;

public class ApplicationPoint {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				MyFrame frame = new MyFrame("Cipher");
				ComboBoxPanel leftPanel = new ComboBoxPanel();
				TextPanel rightPanel = new TextPanel();
				
				@SuppressWarnings("unused")
				ApplicationController controller = new ApplicationController(frame,leftPanel,rightPanel);
			}
		});
		
	}

}
