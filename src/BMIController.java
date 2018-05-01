import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class BMIController {

	protected BMIView theView;
	protected BMIModel theModel;

	public BMIController(BMIView theView, BMIModel theModel) {

		this.theView = theView;
		this.theModel = theModel;
		this.theView.addCalculationListener(new SubmitListener());
		this.theView.addClearListener(new ClearListener());

	}

	public double getBMI() {
		double height = (double)this.theView.getHeight();
		double weight = Double.parseDouble(this.theView.getWeight());
		this.theModel.calcBMI(height, weight);
		return this.theModel.getBMI();
	}

	//(String gender, int age, double weight, int height, double PA)
	public double getEER() {
		double PA;
		String paStr = this.theView.activityGroup.getSelection().toString();
		if (paStr.equals("Inactive")) PA = 1.0;
		else if (paStr.equals("Moderately Active")) PA = 1.27; 
		else PA = 1.45;
		int height = this.theView.getHeight();
		double weight = Double.parseDouble(this.theView.getWeight());
		String gender = this.theView.getGender();
		int age = Integer.parseInt(this.theView.getAge());
		// Need to add PA Choose option
		this.theModel.calcERR(gender, age, weight, height, PA);
		return this.theModel.getERR();
	}

	class SubmitListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			try {
				JOptionPane.showMessageDialog(null, "Your BMI result is:" + getBMI() + "\n Your BMI Status is: " + theModel.getweightStatus() + "\n Your ERR is: " + getEER());
			}
			catch (Exception exeption) {
				String str = "The following erros occur:\n";
				if (theView.getAge().equals("")) {
					str+= "* Missing Age\n";
				}
				if (theView.getWeight().equals("")) {
					str+="* Missing Weight\n";
				}
				if (theView.genderGroup.getSelection()==null) {
					str+="* Missing Gender\n";
				}
				if (theView.activityGroup.getSelection()==null) {
					str+="* Missing Activity selction\n";
				}
				JOptionPane.showMessageDialog(null, str);
			}




		}
	}

	class ClearListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			theView.getActivityGroup().clearSelection();
			theView.getGenderGroup().clearSelection();
			theView.getAgeField().setText("");
			theView.getWeightField().setText("");
			theView.getBodyComboBox().setSelectedIndex(0);
			theView.getHeightSlider().setValue(100);
			JOptionPane.showMessageDialog(null, "The panel has been cleared.");
			

		}
	}

}
