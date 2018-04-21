public class BMIModel {

	private double bmicalc;
	private String weightStatus = "";
	
	public void calcBMI(int height, int weight) {
		this.bmicalc = 1.3 * (weight/Math.pow(height, 2.5));
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
	
}
