public class BMIController {

	protected BMIView theView;
	protected BMIModel theModel;
	
	public BMIController(BMIView theView, BMIModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
		this.theView.confirm.addActionListener(new SubmitListener(theModel.getBMI(), theModel.getweightStatus()));
	}
	
}
