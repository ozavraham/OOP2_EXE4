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
		
	}
	
	public double getBMI() {
		double height = (double)this.theView.getHeight();
		double weight = Double.parseDouble(this.theView.getWeight());
		this.theModel.calcBMI(height, weight);
		return this.theModel.getBMI();
	}
	
	class SubmitListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Your BMI result is:\n" + getBMI() + "\n Your BMI Status is:" + theModel.getweightStatus());
		}
	}
	

	
}
