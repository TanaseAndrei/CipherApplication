package cipher;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
class MyFrame extends JFrame {
	
	private JButton executeButton;
	private ComboBoxPanel leftPanel;
	private TextPanel rightPanel;
	
	public MyFrame(String title) {
		
		super(title);
		
		//Initiate the frame
		initFrame();
		//Initiate the button that need to be pressed to execute a cipher
		initButton();
		
		//Init the panels
		initPanel();
		
		//Pack everything together;
		packing();
		
		//Make the frame visible to the user
		setVisible(true);
	}
	
	////////////////////INITIATING THE FRAME WITH ALL COMPONENTS////////////////////
		
	private void initPanel() {
		
		leftPanel = new ComboBoxPanel();
		rightPanel = new TextPanel();
		
	}
	
	private void initButton() {
		
		executeButton = new JButton("Execute cipher");
		
	}
	
	
	private void initFrame() {
		
		setSize(1280,720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false);
		
	}
	
	////////////////////GETTERS////////////////////
		
	/////OFFSET GETTER/////
	
	public String getOffset() {
		return leftPanel.getOffset();
	}
	
	/////INPUT GETTER/////
	
	public String getInputText() {
		return rightPanel.getInputText();
	}
	
	
	////////////////////SETTERS////////////////////
	
	/////OUTPUT TEXT SETTER/////
	public void setOutputText(String text) {
		rightPanel.setOutputText(text);
	}
	
	//////////HIDE THE OFFSET WHEN CHOOSING ALGORITHMS THAT DO NOT REQUIRE OFFSET//////////
		
	public void hideOffset() {
		leftPanel.hideOffset();
	}
	
	public void showOffset() {
		leftPanel.showOffset();
	}
	
	
	////////////////////UPDATE LEFT PANEL AFTER HIDING OFFSET////////////////////
	public void updateLeftPanel() {
		leftPanel.updatePanel();
	}
	
	////////////////////PACKING EVERYTHING TOGETHER////////////////////
	
	private void packing() {
		
		add(executeButton,BorderLayout.SOUTH);
		add(leftPanel, BorderLayout.WEST);
		add(rightPanel, BorderLayout.EAST);
		
	}
	
	////////////////////LISTENERS////////////////////
	
	/////COMBO BOX/////
	
	//Metoda care primeste ca parametru un obiect de tip ActionListener pentru a adauga un ActionListener pentru ComboBox.
	//Se mai poate implementa pe loc (new ActionListener() { public void actionPerformed(ActionEvent e){...cod}}
	public void addComboBoxListener(ActionListener comboBoxListener) {
		leftPanel.addComboBoxListener(comboBoxListener);
	}
	
	/////EXECUTE BUTTON LISTENER/////
	
	public void addExecuteButtonListener(ActionListener executeButtonListener) {
		executeButton.addActionListener(executeButtonListener);
	}
	
	/////DELETE EXECUTE BUTTON LISTENER/////
	
	//Deoarece adaugam mereu alt actionListener si dorim sa avem doar unul, trebuie sa le stergem pe cele care inca exista
	public void removeExecuteButtonListener() {
		for(ActionListener al : executeButton.getActionListeners()) {
			executeButton.removeActionListener(al);
		}
	}
	
	
	
}
