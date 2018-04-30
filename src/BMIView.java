import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionListener;

public class BMIView extends JFrame{

	final private  JPanel topPanel = new JPanel();
	final private  JLabel header = new JLabel ("Welcome to BMI Calculator!");;
	final private JLabel description = new JLabel("This calculator computes the body mass index and rates it appropriately for men, women and children");;

	final private JPanel genderPanel = new JPanel();
	private JLabel genderL;
	private JRadioButton maleButton = new JRadioButton("Male");
	private JRadioButton femaleButton = new JRadioButton("Female");
	ButtonGroup genderGroup;


	final private JPanel heightPanel = new JPanel();
	private JSlider heightSlider;
	private JLabel heightL;

	final private JPanel bodyPanel = new JPanel();
	final private String[] bodyChoise = {"Small", "Medium","Large"};
	private JComboBox<String> bodyComboBox = new JComboBox<String>(bodyChoise);

	final private JPanel weightPanel = new JPanel();
	private JTextField weight = new JTextField(10);

	final private JPanel agePanel = new JPanel();
	private JTextField age = new JTextField(10); 
	
	
	/* Need to add PA Panel for ERR Calculation */ 
	final private JPanel PAPanel = new JPanel();
	private Component paLabel = new JLabel ("Pyhisical Activity Level:");
	private JRadioButton lowActivityButton = new JRadioButton("Inactive");
	private JRadioButton mediumActivityButton = new JRadioButton("Moderately Active");
	private JRadioButton highActivityButton = new JRadioButton("Extremely Active");
	ButtonGroup activityGroup;
	
	private JPanel westPanel;
//	private JPanel centerPanel;
	private JPanel eastPanel;
	private JPanel southPanel;
	
	final JLabel background;
	
	final private Panel calcPanel = new Panel();
	final public JButton confirm = new JButton ("Click to calculate BMI!");
	
			
	
	
//	private JPanel calcPanel = new JPanel();
//	private JButton calc;

	public BMIView(){

		// Setting up BMIView
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(650, 400);
		Panel bmiPanel = new Panel();
		background = new JLabel(new ImageIcon("background.jpg"));
		background.setLayout(new FlowLayout());
		this.add(background);
		bmiPanel.setLayout(new BorderLayout());
		bmiPanel.add(background);
		this.add(background);

		
		/*
		 * Header Panel
		 */
		
		description.setHorizontalAlignment(JLabel.CENTER);
		description.setFont(new Font("Arial", Font.PLAIN, 12));
		header.setFont(new Font("Arial", Font.BOLD, 16));
		header.setHorizontalAlignment(JLabel.CENTER);
		topPanel.setLayout(new GridLayout(3,1));
		topPanel.add(header);
		topPanel.add(description);
		topPanel.setVisible(true);
		topPanel.setOpaque(false);

		/*
		 * Gender Panel
		 */
		genderL = new JLabel ("Gender: ");
		genderGroup = new ButtonGroup();
		genderGroup.add(maleButton);
		genderGroup.add(femaleButton);
		genderPanel.add(genderL);
		genderPanel.add(maleButton);
		genderPanel.add(femaleButton);
		genderPanel.setVisible(true);
		genderPanel.setOpaque(false);

		/*
		 * Height Panel
		 */
		heightL = new JLabel("100 cm"); // Default value
		heightSlider = new JSlider();
		heightSlider.setMajorTickSpacing(50);
		heightSlider.setMinorTickSpacing(15);
		heightSlider.setValue(110);
		heightSlider.setPaintLabels(true);
		heightSlider.setMaximum(220);
		heightSlider.setPaintTicks(true);
		heightSlider.addChangeListener(new javax.swing.event.ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				heightL.setText(heightSlider.getValue() + " cm");
			}
		});
		heightPanel.add(new JLabel ("Height: "));
		heightPanel.add(heightSlider);
		heightPanel.add(heightL);
		heightPanel.setVisible(true);
		heightPanel.setOpaque(false);

		/*
		 * Body Panel
		 */
		bodyPanel.add(new JLabel ("Body-Frame: "));
		bodyPanel.add(bodyComboBox);
		bodyPanel.setVisible(true);
		bodyPanel.setOpaque(false);

		/*
		 * Weight Panel
		 */
		weightPanel.add(new JLabel ("Weight: "));
		weightPanel.add(weight);
		weightPanel.setVisible(true);
		weightPanel.setOpaque(false);

		/*
		 * Age Panel
		 */
		agePanel.add(new JLabel ("Age: "));
		agePanel.add(age);
		agePanel.setVisible(true);
		agePanel.setOpaque(false);
	
		/*
		 * PA Panel
		 */
		activityGroup = new ButtonGroup();
		activityGroup.add(lowActivityButton);
		activityGroup.add(mediumActivityButton);;
		activityGroup.add(highActivityButton);
		PAPanel.setLayout(new GridLayout (4,1));
		PAPanel.add(paLabel);
		PAPanel.add(lowActivityButton);
		PAPanel.add(mediumActivityButton);
		PAPanel.add(highActivityButton);	
		PAPanel.setVisible(true);
		PAPanel.setOpaque(false);
		
		
		/*
		 * Calculation Panel
		 */
		
		calcPanel.add(confirm);
		
		/*
		 * Main Panel layout
		 */
		
		westPanel = new JPanel(new GridLayout(4,1));
		westPanel.add(genderPanel);
		westPanel.add(heightPanel);
		westPanel.add(weightPanel);
		westPanel.add(agePanel);
		westPanel.setOpaque(false);
		
		eastPanel = new JPanel(new GridLayout(3, 1));
		eastPanel.add(bodyPanel);
		eastPanel.add(PAPanel);
		eastPanel.setOpaque(false);
		
//		centerPanel = new JPanel();
//		centerPanel.setSize(50, 300);
		
		southPanel = new JPanel();
		southPanel.add(calcPanel);
		southPanel.setOpaque(false);
		
		bmiPanel.add(topPanel,BorderLayout.NORTH);
		bmiPanel.add(westPanel,BorderLayout.WEST);
		bmiPanel.add(eastPanel, BorderLayout.EAST);
		bmiPanel.add(southPanel,BorderLayout.SOUTH);
		
		bmiPanel.setVisible(true);
//		background.setLayout(new FlowLayout());
//		bmiPanel.add(background);
		this.add(bmiPanel);
		this.pack();
		this.setVisible(true);
	}
	
	
	public String getGender() throws IllegalArgumentException{
		if (this.genderGroup.getSelection().toString()=="") throw new IllegalArgumentException();
		else return this.genderGroup.getSelection().toString();
	}
	
	public int getHeight() {
		return this.heightSlider.getValue();
	}
	
	public String getBodyFrame() {
		return this.bodyComboBox.getSelectedItem().toString();
	}
	
	public String getWeight() {
		return this.weight.getText();
	}
	
	public String getAge() {
		return this.age.getText();
	}
	
	public Panel getPanel() {
		return this.calcPanel;
	}
	
	public void addCalculationListener(ActionListener event) {
		this.confirm.addActionListener(event);
	}
	
	public String getPA() {
		return this.activityGroup.getSelection().toString();
	}

}




