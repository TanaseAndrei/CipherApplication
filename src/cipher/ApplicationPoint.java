package cipher;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ApplicationPoint {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				MyFrame frame = new MyFrame("Cipher");
				ComboBoxPanel leftPanel = new ComboBoxPanel();
				TextPanel rightPanel = new TextPanel();
				JOptionPane.showMessageDialog(frame, "Welcome to my application, I hope you will like it, you, the one you are trying this.");
				
				@SuppressWarnings("unused")
				ApplicationController controller = new ApplicationController(frame,leftPanel,rightPanel);
			}
		});
		
	}

}
