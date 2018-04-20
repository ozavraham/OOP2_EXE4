import java.awt.event.*;
import javax.swing.*;

public class BMIView extends JFrame{
	private JLabel gender = new JLabel ("Gender: ");
	private JCheckBox male = new JCheckBox("Male");
	private JCheckBox female = new JCheckBox("Female");
	private JLabel actualHeight = new JLabel ("Height: ");
	private JTextField height = new JTextField(10);
	private JLabel bodyf = new JLabel ("Body-Frame: ");
	private JLabel actualw = new JLabel ("Actual Weight: ");
	private JTextField weight = new JTextField(10);
	private JLabel actualAge = new JLabel ("Age: ");
	private JTextField age = new JTextField(10); 
	
	BMIView(){
		JPanel bmiPanel = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		
		bmiPanel.add(gender);
		bmiPanel.add(male);
		bmiPanel.add(female);
		bmiPanel.add(actualHeight);
		bmiPanel.add(height);
		bmiPanel.add(bodyf);
		bmiPanel.add(actualw);
		bmiPanel.add(weight);
		bmiPanel.add(actualAge);
		bmiPanel.add(age);
		
		this.add(bmiPanel);
		
	}
	
}
