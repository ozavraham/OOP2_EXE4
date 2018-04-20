
public class BMIController {

	private double bmiclac;
	
	public void calcBMI(int height, int weight) {
		this.bmiclac = 1.3 * (weight/Math.pow(height, 2.5));
	}
	
	public double getBMI () {
		return this.bmiclac;
	}
}
