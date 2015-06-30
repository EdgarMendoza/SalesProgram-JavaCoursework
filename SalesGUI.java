import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

public class SalesGUI extends JFrame {

	//Labels
	private JLabel nameLabel;
	private JLabel streetLabel;
	private JLabel cityLabel;
	private JLabel stateLabel;
	private JLabel zipLabel;
	private JLabel appOrMusicLabel;
	private JLabel musicLabel;
	private JLabel appLabel;
	private JLabel titleLabel;
	private JLabel dateLabel;
	private JLabel accountLabel;
	
	//TextFields
	private JTextField nameField;
	private JTextField streetField;
	private JTextField cityField;
	private JTextField stateField;
	private JTextField zipField;
	private JTextField titleField;
	private JTextField dateField;
	private JTextField accountField;
	
	//Check boxes
	private JCheckBox appCheck;
	private JCheckBox musicCheck;
	
	//Panels
	private JPanel appOrMusicPanel;
	private JPanel appPanel;
	
	//ComboBox
	private JComboBox<String> musicCombo;
	
	//Radio Buttons
	private JRadioButton gameRadio;
	private JRadioButton prodRadio;
	private JRadioButton eduRadio;
	
	//Button Groups
	private ButtonGroup appGroup;
	private ButtonGroup appOrMusicGroup;
	
	//Buttons
	private JButton submitButton;
	private JButton finishButton;
	
	//Constructor
	public SalesGUI(){
		
		//Title and layout
		super("Mav Tunes");
		setLayout(new GridLayout(12,2));
		
		//Instantiating all my objects
		nameLabel = new JLabel("Name");
		streetLabel = new JLabel("Street");
		cityLabel = new JLabel("City");
		stateLabel = new JLabel("State");
		zipLabel = new JLabel("Zip");
		appOrMusicLabel = new JLabel("Choose One");
		musicLabel = new JLabel("Type of Music");
		appLabel = new JLabel("Type of App");
		titleLabel = new JLabel("Title");
		dateLabel = new JLabel("Date Purchased");
		accountLabel = new JLabel("Account Number");
		
		
		nameField = new JTextField();
		streetField = new JTextField();
		cityField = new JTextField();
		stateField = new JTextField();
		zipField = new JTextField();
		titleField = new JTextField();
		dateField = new JTextField();
		accountField = new JTextField();
	
		dateField.setToolTipText("Enter date in MM/DD/YYYY format");
		
		appCheck = new JCheckBox("App");
		musicCheck = new JCheckBox("Music");
		
		appOrMusicGroup = new ButtonGroup();
		
		appOrMusicGroup.add(appCheck);
		appOrMusicGroup.add(musicCheck);
		
		String[] musicOptions = {"Choose One", "Classical", "Rock", "Country"};
		
		musicCombo = new JComboBox<String>(musicOptions);
		musicCombo.setMaximumRowCount(3);
		
		gameRadio = new JRadioButton("Game");
		prodRadio = new JRadioButton("Productivity");
		eduRadio = new JRadioButton("Education");
		
		appGroup = new ButtonGroup();
		
		appGroup.add(gameRadio);
		appGroup.add(prodRadio);
		appGroup.add(eduRadio);
		
		submitButton = new JButton("SUBMIT");
		finishButton = new JButton("FINISH");
		
		appOrMusicPanel = new JPanel(new GridLayout(1,2));
		
		
		appOrMusicPanel.add(appCheck);
		appOrMusicPanel.add(musicCheck);
		
		appPanel = new JPanel(new GridLayout(1,3));
		
		appPanel.add(gameRadio);
		appPanel.add(prodRadio);
		appPanel.add(eduRadio);
		
		
		//Listeners
		appCheck.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (appCheck.isSelected()){
					musicLabel.setForeground(Color.GRAY);
					musicCombo.setEnabled(false);
				} else {
					musicLabel.setForeground(Color.BLACK);
					musicCombo.setEnabled(true);
				}
				
			}
			
		});
		
		musicCheck.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (musicCheck.isSelected()){
					appLabel.setForeground(Color.GRAY);
					gameRadio.setEnabled(false);
					eduRadio.setEnabled(false);
					prodRadio.setEnabled(false);
				} else {
					appLabel.setForeground(Color.BLACK);
					gameRadio.setEnabled(true);
					eduRadio.setEnabled(true);
					prodRadio.setEnabled(true);
				}
				
			}
			
		});
		
		//Private class Listeners
		OnSubmitClick submitListener = new OnSubmitClick();
		
		submitButton.addActionListener(submitListener);
		
		OnFinishClick finishListener = new OnFinishClick();
		
		finishButton.addActionListener(finishListener);
		
		
		//Adding everything to the frame
		add(nameLabel);
		add(nameField);
		add(streetLabel);
		add(streetField);
		add(cityLabel);
		add(cityField);
		add(stateLabel);
		add(stateField);
		add(zipLabel);
		add(zipField);
		add(appOrMusicLabel);
		add(appOrMusicPanel);
		add(musicLabel);
		add(musicCombo);
		add(appLabel);
		add(appPanel);
		add(titleLabel);
		add(titleField);
		add(dateLabel);
		add(dateField);
		add(accountLabel);
		add(accountField);
		add(submitButton);
		add(finishButton);
		
		
	}
	
	
	//Method to clear all the information and set all buttons to original state	
	public void clearAll(){
		nameField.setText("");
		streetField.setText("");
		cityField.setText("");
		stateField.setText("");
		zipField.setText("");
		titleField.setText("");
		dateField.setText("");
		accountField.setText("");
		appCheck.setSelected(false);
		musicCheck.setSelected(false);
		musicCombo.setSelectedIndex(0);
		gameRadio.setSelected(false);
		prodRadio.setSelected(false);
		eduRadio.setSelected(false);
	}
	
	//Checks to ensure that all fields are entered before allowing info to be submit
	public boolean checkInput(){
		
		if (nameField.getText().equals("")){
			nameField.requestFocus();
			return false;
		} else if(streetField.getText().equals("")){
			streetField.requestFocus();
			return false;
		}else if(cityField.getText().equals("")){
			cityField.requestFocus();
			return false;
		}else if(stateField.getText().equals("")){
			stateField.requestFocus();
			return false;
		}else if(zipField.getText().equals("")){
			zipField.requestFocus();
			return false;
		}else if(titleField.getText().equals("")){
			titleField.requestFocus();
			return false;
		}else if(dateField.getText().equals("")){
			dateField.requestFocus();
			return false;
		}else if(accountField.getText().equals("")){
			accountField.requestFocus();
			return false;
		}else if (!appCheck.isSelected() && !musicCheck.isSelected()){
			appCheck.requestFocus();
			return false;
		}else if(musicCheck.isSelected() && musicCombo.getSelectedIndex() == 0){
			musicCombo.requestFocus();
			return false;
		}
		else
			return true;
	}
	
	//Turns the string into a date object
	public Date parseDate(String dateString){
		
		String[] args = dateString.split("/");
		int[] ints = new int[3];
		
		for(int i = 0; i < args.length; i++){
			ints[i] = Integer.parseInt(args[i]);
		}
		
		Date date = new Date(ints[1], ints[0], ints[2]);
		return date;
	}
	
	//Private class to add purchases to a user
	private class OnSubmitClick implements ActionListener{
		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//First check to make sure that all Info is filled out
			if(checkInput()){
				
				//Check to see if the customer already exists based upon name entered
				int index = Sales.checkCustomerList(nameField.getText());
				
				//If customer doesn't exist, create customer
				if(index < 0){
					Customer c = new Customer(nameField.getText(), new Address(streetField.getText(),
							cityField.getText(), stateField.getText(), Integer.parseInt(zipField.getText())),
							Integer.parseInt(accountField.getText()));
					Sales.createCustomer(c);
					
					//Update the index so you can add purchases to that customer
					index = Sales.checkCustomerList(nameField.getText());
				}
				
				//Once customer exists, begin to add items to that customer
				
				//Create the purchase to add
				
				//Product that will be filled with either a music or app product
				Product purchase;
				
				//If we are trying for an app product
				if(appCheck.isSelected()){
					//Create purchase as an app
					try{
						AppReader reader = new AppReader();
						reader.openAppFile();
						purchase = reader.searchFile(titleField.getText(), parseDate(dateField.getText()), appType());
						reader.closeAppFile();
						if(purchase != null)
							Sales.addPurchase(index, purchase);
						else
							JOptionPane.showMessageDialog(null, "Not a valid item");	
						clearAll();
					}catch(Exception ex){
						System.err.println(ex.getMessage());
					}
					
					//If we are trying for a music product
				}else if (musicCheck.isSelected()){
					try{
						MusicReader reader = new MusicReader();
						reader.openMusicFile();
						purchase = reader.searchFile(titleField.getText(), parseDate(dateField.getText()), genreType());
						reader.closeMusicFile();
						if(purchase != null)
							Sales.addPurchase(index, purchase);
						else
							JOptionPane.showMessageDialog(null, "Not a valid item");	
						clearAll();
					}catch(Exception ex){
						System.err.println(ex.getMessage());
					}
				}
				
				
				//Product has been created and assigned to user
				
				//Message to show if we are missing info
			}else{
				String message = "Please ensure all fields are entered";
				JOptionPane.showMessageDialog(null, message, "Missing Info", JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		//Creating the enum to send off for creating app
		public AppType appType(){
			
			AppType type = AppType.GAME;
			
			if(gameRadio.isSelected())
				type = AppType.GAME;
			if(eduRadio.isSelected())
				type = AppType.EDUCATION;
			if(prodRadio.isSelected())
				type = AppType.PRODUCTIVITY;
			
			
			
			return type;
		}
		
		//Creating the enum to send off for creating music
		public GenreType genreType(){
			
			GenreType type = GenreType.CLASSICAL;
			
			if(musicCombo.getSelectedIndex() == 1)
				type = GenreType.CLASSICAL;
			else if(musicCombo.getSelectedIndex() == 2)
				type = GenreType.ROCK;
			else if(musicCombo.getSelectedIndex() == 3)
				type = GenreType.COUNTRY;
				
			return type;
		}
		
	}
	
	//Method for to display results
	private class OnFinishClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String customers = "";
			
			//Creates a string with all the users history in it
			for(Customer c: Sales.customerList){
				customers += (c.createHistory() + "\n");
			}
			//Pushes out all the info assuming at least one record has been created
			if(Sales.customerList != null){
				JOptionPane.showMessageDialog(null, customers, "Purchase History", JOptionPane.PLAIN_MESSAGE);
			}
			
		}
		
	}
}
