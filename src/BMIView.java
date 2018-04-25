import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMIView extends JFrame{

	final private  JPanel topPanel = new JPanel();
	final private  JLabel header= new JLabel ("Welcome to BMI Calculator!");;

	final private JPanel genderPanel = new JPanel();
	private JLabel genderL;
	private final String[] genderChoise = {"Male", "Female"};
	private JComboBox genderComboBox = new JComboBox(genderChoise);

	final private JPanel heightPanel = new JPanel();
	private JSlider heightSlider;
	private JLabel heightL;

	final private JPanel bodyPanel = new JPanel();
	final private String[] bodyChoise = {"Small", "Medium","Large"};
	private JComboBox bodyComboBox = new JComboBox(bodyChoise);

	final private JPanel weightPanel = new JPanel();
	private JTextField weight = new JTextField(10);

	final private JPanel agePanel = new JPanel();
	private JTextField age = new JTextField(10); 
	
	final private Panel calcPanel = new Panel();
	final public JButton confirm = new JButton ("Click to calculate BMI!");
	public JLabel result1 = new JLabel ("");
	public JLabel result2 = new JLabel ("");
			
	
//	private JPanel calcPanel = new JPanel();
//	private JButton calc;

	public BMIView(){

		// Setting up BMIView
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 600);
		this.setLayout(new BorderLayout());
		
		
		Panel bmiPanel = new Panel();
		bmiPanel.setLayout(new GridLayout(8, 1));
		
		/*
		 * Header Panel
		 */
		
		topPanel.add(header);
		topPanel.setVisible(true);

		/*
		 * Gender Panel
		 */
		genderL = new JLabel ("Gender: ");
		genderPanel.add(genderL);
		genderPanel.add(genderComboBox);
		genderPanel.setVisible(true);

		/*
		 * Height Panel
		 */
		heightL = new JLabel("");
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

		/*
		 * Body Panel
		 */
		bodyPanel.add(new JLabel ("Body-Frame: "));
		bodyPanel.add(bodyComboBox);
		bodyPanel.setVisible(true);

		/*
		 * Weight Panel
		 */
		weightPanel.add(new JLabel ("Weight: "));
		weightPanel.add(weight);
		weightPanel.setVisible(true);

		/*
		 * Age Panel
		 */
		agePanel.add(new JLabel ("Age: "));
		agePanel.add(age);
		agePanel.setVisible(true);
	
		/*
		 * Calculation Panel
		 */
		
		calcPanel.add(confirm);
		calcPanel.add(result1);
		calcPanel.add(result2);
		
		bmiPanel.add(topPanel);
		bmiPanel.add(genderPanel);
		bmiPanel.add(heightPanel);
		bmiPanel.add(bodyPanel);
		bmiPanel.add(weightPanel);
		bmiPanel.add(agePanel);
		bmiPanel.add(calcPanel);
		bmiPanel.setVisible(true);
		this.add(bmiPanel);
		this.setVisible(true);
	}
	
	public String getGender() {
		System.out.println(this.genderComboBox.getSelectedItem());
		return this.genderComboBox.getSelectedItem().toString();
	}
	
	public int getHeight() {
		System.out.println(this.heightSlider.getValue());
		return this.heightSlider.getValue();
	}
	
	public String getBodyFrame() {
		System.out.println(this.bodyComboBox.getSelectedItem());
		return this.bodyComboBox.getSelectedItem().toString();
	}
	
	public String getWeight() {
		System.out.println(this.weight.getText());
		return this.weight.getText();
	}
	
	public String getAge() {
		System.out.println(this.age.getText());
		return this.age.getText();
	}
	
	public Panel getPanel() {
		return this.calcPanel;
	}
	
	public void addCalculationListener(ActionListener event) {
		this.confirm.addActionListener(event);
	}

}




