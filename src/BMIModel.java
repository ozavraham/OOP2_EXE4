import java.text.DecimalFormat;

public class BMIModel {

	/** BMI Model - The Model part of the MVC .
	 * 	The logic behind all the calculator.
	 */
	
	private double bmiCalc;
	private String weightStatus = "";
	private double errCalc;
	
	/* calcBMI()
	 * Calculate the BMI value and assign it to bmiCalc.
	 */
	public void calcBMI(double height, double weight) {
		this.bmiCalc = 1.3 * (weight/Math.pow((height/100), 2.5));
		// To present only 2 digits after the decimal dot.
		DecimalFormat df = new DecimalFormat("#.##"); 
		String str = df.format(this.bmiCalc);
		this.bmiCalc = Double.valueOf(str);
		// Deciding the Weight status according to the BMI Value.
		if (this.bmiCalc < 15) this.weightStatus= "Anorexic";
		else if (this.bmiCalc >= 15 && this.bmiCalc < 18.5) this.weightStatus= "Underwight";
		else if (this.bmiCalc >= 18.5 && this.bmiCalc < 25) this.weightStatus = "Normal";
		else if (this.bmiCalc >= 25 && this.bmiCalc < 30) this.weightStatus = "Overweight";
		else if (this.bmiCalc >= 30 && this.bmiCalc < 35) this.weightStatus = "Obese";
		else if (this.bmiCalc > 35) this.weightStatus = "Extreme Obese";
	}

	/* calcERR()
	 * Calculate the ERR value and assign it to errCalc.
	 */
	public void calcERR(String gender, int age, double weight, int height, double PA) {
		DecimalFormat df = new DecimalFormat("#.##");
		double err;
		height = height/100; // cm -> meters
		if (gender=="Male") {
			err = (662 - (9.53*age) + (PA*((15.91*weight) + (539.6*height))));
			String str = df.format(err);
			err = Double.valueOf(str);
		}
		else {
			err = (354 -(6.91*age)) + (PA*((9.36*weight)+(726*height)));
			String str = df.format(err);
			err = Double.valueOf(str);
		}
		this.errCalc = err;
	}
	
	/** getBMI()
	 * @return the BMI value 
	 */
	public double getBMI () {
		return this.bmiCalc;
	}
	
	/** getERR()
	 * @return the ERR value 
	 */
		public double getERR() {
		return this.errCalc;
	}
	
	/** getWeightStatus()
	 * @return the Weight status 
	 */
	public String getWeightStatus() {
		return this.weightStatus;
	}
	
}
