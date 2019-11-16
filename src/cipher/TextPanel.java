package cipher;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
class TextPanel extends JPanel {

	private JTextArea inputArea, outputArea;
	private JScrollPane inputScroll, outputScroll;
	
	public TextPanel() {
		
		//////////PANEL METHODS///////
		
		/*
		//Initiate the size of the panel
		initSize();
		*/
		
		//Initiate the border of the entire panel
		initBorder();
		//Setup the layout of the panel
		initLayout();
		
		//////////TEXT AREAS METHODS///////
		//Initiate the text areas
		initTextArea();
		//Initiate the borders for the 2 text areas
		initTextAreaBorder();
		//Create scrolls for both text areas
		initScrollPane();
		
		//Pack everything together
		packing();
		
	}

	private void packing() {
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(inputScroll,gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(outputScroll,gbc);
		
	}
	
	private void initScrollPane() {
		
		inputScroll = new JScrollPane(inputArea);
		outputScroll = new JScrollPane(outputArea);
		
	}

	private void initTextAreaBorder() {
		
		inputArea.setBorder(new LineBorder(Color.black));
		inputArea.setLineWrap(true);
		
		outputArea.setBorder(new LineBorder(Color.black));
		outputArea.setLineWrap(true);
	}
	
	private void initBorder() {

		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border inner = BorderFactory.createTitledBorder("Text");
		setBorder(BorderFactory.createCompoundBorder(outer,inner));
		
	}

	private void initLayout() {
		
		setLayout(new GridBagLayout());
		
	}

	private void initTextArea() {
		
		//Exact ce am spus mai jos, rows and columns.
		inputArea = new JTextArea(10,88);
		Font font = inputArea.getFont();
		float size = font.getSize() + 2.0f;
		inputArea.setFont(font.deriveFont(size));
		
		outputArea = new JTextArea(10,88);
		outputArea.setEditable(false);
		outputArea.setFont(font.deriveFont(size));
		
	}
	
	//Ar trebui evitate aceste metode, trebuie sa ne folosim de proprietatile componentelor si de layout pentru ajustarea dimensiunii
	//O proprietate ar fi de exemplu la textarea folosirea constructorului pentru rows si columns.
	/*private void initSize() {
		
		//setPreferredSize sets the minimum
		Dimension size = getPreferredSize();
		size.width = 390;
		setPreferredSize(size);
		
	}*/
	
	public String getInputText() {
		return inputArea.getText();
	}
	
	public void setOutputText(String text) {
		outputArea.setText("");
		outputArea.setText(text);
	}
	
}
