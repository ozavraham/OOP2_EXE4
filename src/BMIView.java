import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.awt.event.ActionListener;

public class BMIView{

	/** BMI View - The View part of the MVC .
	 * 	The class that building the GUI to interact with the user.
	 */

	private  JPanel topPanel;
	private  JLabel header;
	private JLabel description1;
	private JLabel description2;

	private JPanel genderPanel;
	private JLabel genderL;
	private JRadioButton maleButton;
	private JRadioButton femaleButton;
	ButtonGroup genderGroup;


	private JPanel heightPanel;
	private JSlider heightSlider;
	private JLabel heightL;

	private JPanel bodyPanel;
	private JLabel bodyL;
	private String[] bodyChoise = {"Small", "Medium","Large"};
	private JComboBox<String> bodyComboBox = new JComboBox<String>(bodyChoise);

	private JPanel weightPanel;
	private JLabel weightL;
	private JTextField weight;
	private JLabel value;

	private JPanel agePanel;
	private JLabel ageL;
	private JTextField age; 
	private JLabel years; 

	private JPanel PAPanel;
	private JLabel paLabel;
	private JRadioButton lowActivityButton;
	private JRadioButton mediumActivityButton;
	private JRadioButton highActivityButton;
	ButtonGroup activityGroup;

	private JPanel westPanel;
	private JPanel eastPanel;
	private JPanel southPanel;
	private JPanel centerPanel;

	private JPanel calcPanel;
	public JButton confirm;
	public JButton clear;

	private JLabel background;
	
	

	public BMIView(){

		JFrame frame = new JFrame(); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());

		/*
		 * Header Panel
		 */
		topPanel = new JPanel(new GridBagLayout());
		topPanel.setLayout(new GridLayout(3, 1));
		header = new JLabel ("Welcome to BMI Calculator!");;
		description1 = new JLabel("This calculator computes the body mass index and the ERR and rates it appropriately for both mens and womens.");
		description2 = new JLabel("Fill in the details in the appropiate location, click the Calculate button to calculate, Clear button to clear the panel.");
		description1.setHorizontalAlignment(JLabel.CENTER);
		description1.setFont(new Font("Arial", Font.PLAIN, 12));
		description2.setHorizontalAlignment(JLabel.CENTER);
		description2.setFont(new Font("Arial", Font.PLAIN, 12));
		header.setFont(new Font("Arial", Font.BOLD, 20));
		header.setHorizontalAlignment(JLabel.CENTER);
		topPanel.add(header);
		topPanel.add(description1);
		topPanel.add(description2);
		topPanel.setOpaque(false);

		/*
		 * Gender Panel
		 */
		genderPanel = new JPanel(new GridBagLayout());
		genderL = new JLabel ("Gender: ");
		genderL.setFont(new Font("Arial", Font.BOLD,14));
		genderGroup = new ButtonGroup();
		maleButton = new JRadioButton("Male");
		maleButton.setActionCommand("Male");
		femaleButton = new JRadioButton("Female");
		femaleButton.setActionCommand("Female");
		genderGroup.add(maleButton);
		genderGroup.add(femaleButton);
		genderPanel.add(genderL);
		genderPanel.add(maleButton);
		genderPanel.add(femaleButton);
		genderL.setVerticalAlignment(JLabel.CENTER );
		genderPanel.setOpaque(false);

		/*
		 * Height Panel
		 */
		heightPanel = new JPanel(new GridBagLayout());
		heightPanel.setLayout(new GridLayout(2, 1,0,-25));
		heightL = new JLabel ("Height: 100 cm"); // Default value
		heightSlider = new JSlider();
		heightSlider.setMajorTickSpacing(50);
		heightSlider.setMinorTickSpacing(15);
		heightSlider.setValue(110);
		heightSlider.setPaintLabels(true);
		heightSlider.setMaximum(220);
		heightSlider.setPaintTicks(true);
		heightSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				heightL.setText("Height: " + heightSlider.getValue() + " cm");
			}
		});
		heightL.setHorizontalAlignment(JLabel.CENTER);
		heightPanel.add(heightL);
		heightPanel.add(heightSlider);
		heightPanel.setOpaque(false);

		/*
		 * Body Panel
		 */
		bodyPanel = new JPanel(new GridBagLayout());
		bodyL = new JLabel ("Body-Frame: ");
		bodyL.setFont(new Font("Arial", Font.BOLD, 14));
		bodyPanel.add(bodyL);
		bodyPanel.add(bodyComboBox);
		bodyPanel.setOpaque(false);

		/*
		 * Weight Panel
		 */
		weightPanel = new JPanel(new GridBagLayout());
		weight = new JTextField(10);
		weightL = new JLabel ("Weight: ");
		weightL.setFont(new Font ("Arial", Font.BOLD, 14));
		value = new JLabel("kg");
		weightPanel.add(weightL);
		weightPanel.add(weight);
		weightPanel.add(value);
		weightPanel.setOpaque(false);

		/*
		 * Age Panel
		 */
		agePanel = new JPanel(new GridBagLayout());
		age = new JTextField(10);
		years = new JLabel("years");
		ageL = new JLabel ("Age: ");
		ageL.setFont(new Font ("Arial", Font.BOLD, 14));
		agePanel.add(ageL);
		agePanel.add(age);
		agePanel.add(years);
		agePanel.setOpaque(false);

		/*
		 * PA Panel
		 */
		PAPanel = new JPanel();
		paLabel = new JLabel ("Pyhisical Activity Level:");
		paLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lowActivityButton = new JRadioButton("Inactive");
		lowActivityButton.setActionCommand("Inactive");
		mediumActivityButton = new JRadioButton("Moderately Active");
		mediumActivityButton.setActionCommand("Moderately Active");
		highActivityButton = new JRadioButton("Extremely Active");
		highActivityButton.setActionCommand("Extremely Active");
		activityGroup = new ButtonGroup();
		activityGroup.add(lowActivityButton);
		activityGroup.add(mediumActivityButton);;
		activityGroup.add(highActivityButton);
		PAPanel.setLayout(new GridLayout (4,1));
		PAPanel.add(paLabel);
		PAPanel.add(lowActivityButton);
		PAPanel.add(mediumActivityButton);
		PAPanel.add(highActivityButton);
		PAPanel.setOpaque(false);

		/*
		 * Calculation Panel
		 */
		calcPanel = new JPanel();
		confirm = new JButton ("Calculate!");
		clear = new JButton ("Clear the board!");
		calcPanel.add(confirm);
		calcPanel.add(clear);
		calcPanel.setOpaque(false);

		/*
		 * Main Panel layout
		 */
		westPanel = new JPanel(new GridLayout(3,1));
		westPanel.add(genderPanel);
		westPanel.add(heightPanel);
		westPanel.add(weightPanel);
		westPanel.setOpaque(false);
		
		eastPanel = new JPanel(new GridLayout(3, 1));
		eastPanel.add(agePanel);
		eastPanel.add(bodyPanel);
		eastPanel.add(PAPanel);
		eastPanel.setOpaque(false);

		southPanel = new JPanel(new GridBagLayout());
		southPanel.add(calcPanel);
		southPanel.setOpaque(false);
		
		centerPanel = new JPanel(new GridBagLayout());
		JLabel icon = new JLabel(new ImageIcon("./icon.jpg"));
		icon.setSize(100, 100);
		centerPanel.add(icon);
		centerPanel.setOpaque(false);

		
		JPanel bmiPanel = new JPanel();
		bmiPanel.setLayout(new BorderLayout());
		bmiPanel.add(topPanel,BorderLayout.NORTH);
		bmiPanel.add(westPanel,BorderLayout.WEST);
		bmiPanel.add(eastPanel, BorderLayout.EAST);
		bmiPanel.add(southPanel,BorderLayout.SOUTH);
		bmiPanel.add(centerPanel,BorderLayout.CENTER); 
		bmiPanel.setOpaque(false);	

		background = new JLabel(new ImageIcon("./background.jpg"));
		background.setSize(600, 500);
		background.getPreferredSize();
		background.add(bmiPanel);
		background.setLayout(new FlowLayout());

		frame.setContentPane(background);
		frame.pack();
		frame.setVisible(true);
	}

	public String getGender() throws IllegalArgumentException{
		return this.genderGroup.getSelection().getActionCommand();
	}

	public int getHeight() {
		return this.heightSlider.getValue();
	}

	public String getBodyFrame() {
		return this.bodyComboBox.getSelectedItem().toString();
	}

	/** getWeight()
	 * @return the weight inside the weight TextField
	 * @return 0 if no value was inserted.
	 */

	public int getWeight() {
		int weight = 0;
		try{
			weight = Integer.parseInt(this.weight.getText());
		}
		catch (NumberFormatException e) {
			return 0;
		}
		return weight;
	}

	/** getAge()
	 * @return the age inside the age TextField
	 * @return 0 if no value was inserted.
	 */
	public int getAge(){
		int age = 0;
		try{
			age = Integer.parseInt(this.age.getText());
		}
		catch (NumberFormatException e) {
			return 0;
		}
		return age;
	}

	public JPanel getPanel() {
		return this.calcPanel;
	}

	/*
	 * Adding the ActionLisetner to the Confirm Button.
	 */
	public void addCalculationListener(ActionListener event) {
		this.confirm.addActionListener(event);
	}

	/*
	 * Adding the ActionLisetner to the Clear Button.
	 */
	public void addClearListener(ActionListener event) {
		this.clear.addActionListener(event);
	}

	public String getPA() {
		return this.activityGroup.getSelection().getActionCommand();
	}

	public JTextField getAgeField() {
		return this.age;
	}

	public JTextField getWeightField() {
		return this.weight;
	}

	public ButtonGroup getActivityGroup() {
		return this.activityGroup;
	}

	public JComboBox<String> getBodyComboBox(){
		return this.bodyComboBox;
	}

	public ButtonGroup getGenderGroup() {
		return this.genderGroup;
	}

	public JSlider getHeightSlider() {
		return this.heightSlider;
	}
	
	/**
	 * Checking if some of the fields is missing information
	 * @return true if its is, false otherwise
	 */
	public boolean hasEmptyField() {
		boolean isEmpty = false;
		if (this.age.getText().trim().isEmpty() || this.weight.getText().trim().isEmpty() || this.genderGroup.getSelection()==null || this.activityGroup.getSelection().getActionCommand().equals(null)) {
			isEmpty = true;
		}
		return isEmpty;
	}

}


