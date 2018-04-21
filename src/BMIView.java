import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;

public class BMIView extends JFrame{

	private JPanel topPanel = new JPanel();
	private JLabel header;

	private JPanel genderPanel = new JPanel();
	private JLabel genderL;
	private final String[] genderChoise = {"Male", "Female"};
	private JComboBox genderComboBox = new JComboBox(genderChoise);

	private JPanel heightPanel = new JPanel();
	private JSlider heightSlider;
	private JLabel heightL;

	private JPanel bodyPanel = new JPanel();
	private final String[] bodyChoise = {"Small", "Medium","Large"};
	private JComboBox bodyComboBox = new JComboBox(bodyChoise);

	private JPanel weightPanel = new JPanel();
	private JTextField weight = new JTextField(10);

	private JPanel agePanel = new JPanel();
	private JTextField age = new JTextField(10); 
	
//	private JPanel calcPanel = new JPanel();
//	private JButton calc;

	public BMIView(){

		// Setting up BMIView
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);


		JPanel bmiPanel = new JPanel();

		/*
		 * Header Panel
		 */

		header = new JLabel ("Welcome to BMI Calculator!");
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
		heightL = new JLabel ("");
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
				heightL.setText("You height: " + heightSlider.getValue() + " cm");
			}
		});
		heightPanel.add( new JLabel ("Height: "));
		heightPanel.add(heightSlider);
		heightPanel.add(heightL);

		/*
		 * Body Panel
		 */
		bodyPanel.add(new JLabel ("Body-Frame: "));
		bodyPanel.add(bodyComboBox);

		/*
		 * Weight Panel
		 */
		weightPanel.add(new JLabel ("Weight: "));
		weightPanel.add(weight);

		/*
		 * Age Panel
		 */
		agePanel.add(new JLabel ("Age: "));
		agePanel.add(age);
		
		/*
		 * Calculation Panel
		 */
		//calcPanel.add(calc);

		bmiPanel.add(topPanel);
		bmiPanel.add(genderPanel);
		bmiPanel.add(heightPanel);
		bmiPanel.add(bodyPanel);
		bmiPanel.add(weightPanel);
		bmiPanel.add(agePanel);
		//bmiPanel.add(calcPanel);
		this.add(bmiPanel);
	
		this.setVisible(true);

	}
	
	public String getGender() {
		return this.genderComboBox.getSelectedItem().toString();
	}
	
	public int getHeight() {
		return this.heightSlider.getValue();
	}
	
	public String getBodyFrame() {
		return this.bodyComboBox.getSelectedItem().toString();
	}
	
	public int getWeight() {
		return Integer.parseInt(this.weight.getText());
	}
	
	public int getAge() {
		return Integer.parseInt(this.age.getText());
	}

}


