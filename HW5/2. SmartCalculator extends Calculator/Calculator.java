public class Calculator {
	
	protected String calcProc;
	protected boolean solarBatteryExistance;
	protected String serialNumber;
	
	Calculator (String calcProc, boolean solarBatteryExistance, String serialNumber) {
		this.calcProc = calcProc;
		this.solarBatteryExistance = solarBatteryExistance;
		this.serialNumber = serialNumber;
	}
	
	Calculator () {
		
	}
	
	public String toString() {
		return("Calculator № " + serialNumber);
	}
	
	public Calculator clone() {
		Calculator x = new Calculator();
		x.calcProc = calcProc;
		x.solarBatteryExistance = solarBatteryExistance;
		x.serialNumber = serialNumber;
		return x;
	}
	
	public int hashCode () {
		int q = 12345;
		
		for (int i = 0; i < calcProc.length(); i++){
			q +=  calcProc.charAt(i) * 3 / 2;
		}
		
		for (int i = 0; i < serialNumber.length(); i++){
			q +=  serialNumber.charAt(i) * 3 / 2;
		}
		
		if (solarBatteryExistance) {
			q += q * 123;
		}
		else {
			q += q - q / 2 + q / 3;
		}
		return q;
	}
	
	public boolean equals (Calculator x) {
		if (hashCode() == x.hashCode()) {
			return true;
		}
		else {
			return false;
		}
	} 
	
	public double sum (double a, double b) {
		return (a + b);
	}
	
	public double multiplication (double a, double b) {
		return (a * b);
	}
	
	public double diff (double a, double b) {
		return (a - b);
	}
	
	public double div (double a, double b) {
		return (a / b);
	}
	
}