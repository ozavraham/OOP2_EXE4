import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class BMIController {

	/** BMI Controller - The Controller part of the MVC .
	 * 	The class that connect between the View and Model.
	 */

	protected BMIView theView;
	protected BMIModel theModel;

	/** Constructor
	 * Adding the button's listener's to the buttun's
	 * @param theView
	 * @param theModel
	 */
	public BMIController(BMIView theView, BMIModel theModel) {

		this.theView = theView;
		this.theModel = theModel;
		this.theView.addCalculationListener(new SubmitListener());
		this.theView.addClearListener(new ClearListener());

	}

	/** getBMI()
	 * Getting the required information from the view, and send it to the model for calculation.
	 * @return the BMI value according to the input.
	 * @throws Exception 
	 */
	public double getBMI() throws NumberFormatException{
		if (theView.getAge()==0 | theView.getWeight()==0) throw new NumberFormatException();
		double height = (double) this.theView.getHeight();
		double weight = (double) this.theView.getWeight();	
		this.theModel.calcBMI(height, weight);
		return this.theModel.getBMI();
	}


	/** getERR
	 * Getting the required information from the view, and send it to the model for calculation.
	 * @return the ERR value according to the input.
	 */
	public double getEER() {
		double PA;
		String paStr = this.theView.activityGroup.getSelection().toString();
		if (paStr.equals("Inactive")) PA = 1.0;
		else if (paStr.equals("Moderately Active")) PA = 1.27; 
		else PA = 1.45;
		int height = this.theView.getHeight();
		double weight = (double)this.theView.getWeight();
		String gender = this.theView.getGender();
		int age =this.theView.getAge();
		// Need to add PA Choose option
		this.theModel.calcERR(gender, age, weight, height, PA);
		return this.theModel.getERR();
	}

	/** SubmitListner
	 * Sending the information to the calculation's methods above (getBMI() and getERR()).
	 * Handel exeptions such as empty input or Missing input on one of the fields.
	 */
	class SubmitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			try {
				JOptionPane.showMessageDialog(null, "Your BMI result is:" + getBMI() + "\n Your BMI Status is: " + theModel.getWeightStatus() + "\n Your ERR is: " + getEER());
			}
			catch (NumberFormatException e) {
				if (!theView.getAgeField().getText().trim().isEmpty()  | !theView.getWeightField().getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Wrong input inserted!");
				}
				else {
					String str = "The following erros occur:\n";
					if (theView.getAge()==0) {
						str+= "* Missing Age\n";
					}
					if (theView.getWeight()==0) {
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
	}

	/** ClearListner
	 * Setting all the components value to defualt value.
	 */
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
