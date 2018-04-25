import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class SubmitListener implements ActionListener {

	double bmiResult; 
	String bmiStatus;
	
	public SubmitListener(double bmiResult, String bmiStatus) {
		this.bmiResult = bmiResult;
		this.bmiStatus = bmiStatus;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Your BMI result is:\n" + this.bmiResult + "\n Your BMI Status is:" + this.bmiStatus);
	}

}
