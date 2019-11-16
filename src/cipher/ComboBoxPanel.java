package cipher;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

@SuppressWarnings("serial")
class ComboBoxPanel extends JPanel {

	private final String []CIPHERS = {"Caesar's Cipher", "ROT13", "Beaufort Cipher", "Autokey Cipher"};
	@SuppressWarnings("rawtypes")
	private JComboBox comboCiphers;
	private JTextField offset;
	private JLabel info;
	
	public ComboBoxPanel() {
		
		initSize();
		initComboBox();
		initBorder();
		initLayout();
		initTextField();
		initLabel();
		
		packing();
		
	}
	
	
	private void initLabel() {
		info = new JLabel("Choose the algorithm and offset accordingly");
	}
	
	private void initTextField() {
		
		offset = new JTextField(10);
		
	}
	
	private void initLayout() {
		
		setLayout(new GridBagLayout());
		
	}

	private void packing() {
		GridBagConstraints gbc = new GridBagConstraints();
		//Fie de punem 1 sau 2 sau 3, etc. pentru grids, tot in mijloc se va pune combobox-ul.
		//Daca deasupra aveam 2 butoane si 1 in dreapta la combobox, punand spre ex: gridx = 1 si gridy = 1, combobox-ul se punea in acea pozitie.
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(info,gbc);
		gbc.gridy = 1;
		add(comboCiphers,gbc);
		gbc.gridy = 2;
		add(offset,gbc);
		
	}

	private void initBorder() {

		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border inner = BorderFactory.createTitledBorder("Choose the cipher");
		setBorder(BorderFactory.createCompoundBorder(outer, inner));
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initComboBox() {

		comboCiphers = new JComboBox(CIPHERS);
		comboCiphers.setSelectedIndex(-1);
		
	}

	private void initSize() {
		
		Dimension size = getPreferredSize();
		//Il facem lat de 390
		size.width = 640;
		//Setam dimensiunea minima pentru afisare a panel-ului
		setPreferredSize(size);
		
	}
	
	public void hideOffset() {
		offset.setVisible(false);
	}
	
	public void showOffset() {
		offset.setVisible(true);
	}
	
	//Trebuie sa revalidam componentele pe care le stergem sau ascundem
	//Trebuie sa le redesenam
	//Trebuie facut update mereu la container
	public void updatePanel() {
		revalidate();
		repaint();
	}
	
	public void addComboBoxListener(ActionListener comboBoxListener) {
		comboCiphers.addActionListener(comboBoxListener);
	}
	
	public String getOffset() {
		return offset.getText();
	}
	
}
