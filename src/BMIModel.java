import java.text.DecimalFormat;

public class BMIModel {

	private double bmicalc;
	private String weightStatus = "";
	private double errCalc;
	
	public void calcBMI(double height, double weight) {
		this.bmicalc = 1.3 * (weight/Math.pow((height/100), 2.5));
		DecimalFormat df = new DecimalFormat("#.##");
		String str = df.format(this.bmicalc);
		this.bmicalc = Double.valueOf(str);
		if (this.bmicalc < 15) this.weightStatus= "Anorexic";
		else if (this.bmicalc >= 15 && this.bmicalc < 18.5) this.weightStatus= "Underwight";
		else if (this.bmicalc >= 18.5 && this.bmicalc < 25) this.weightStatus = "Normal";
		else if (this.bmicalc >= 25 && this.bmicalc < 30) this.weightStatus = "Overweight";
		else if (this.bmicalc >= 30 && this.bmicalc < 35) this.weightStatus = "Obese";
		else if (this.bmicalc > 35) this.weightStatus = "Extreme Obese";
	}
	
	public double getBMI () {
		return this.bmicalc;
	}
	
	public String getweightStatus() {
		return this.weightStatus;
	}
	
	public void calcERR(String gender, int age, double weight, int height, double PA) {
		DecimalFormat df = new DecimalFormat("#.##");
		double err;
		height = height/100; // cm -> meters
		if (gender=="Male") {
			// EER MALE = (662 - (9.53*age) + (PA*((15.91*weight) + (539.6*height)))
			err = (662 - (9.53*age) + (PA*((15.91*weight) + (539.6*height))));
			String str = df.format(err);
			err = Double.valueOf(str);
		}
		else {
			// EER FEMALE = (354 - (6.91 x age)) + (PA x ((9.36 x Weight) + (726 x Height)))
			err = (354 -(6.91*age)) + (PA*((9.36*weight)+(726*height)));
			String str = df.format(err);
			err = Double.valueOf(str);
		}
		this.errCalc = err;
	}
	
	public double getERR() {
		return this.errCalc;
	}
	
}
