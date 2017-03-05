public class SmartCalculator extends Calculator {
	
	protected boolean ramExisting;

	public SmartCalculator (String calcProc, boolean solarBatteryExistance, String serialNumber, boolean ramExisting) {
		super(calcProc, solarBatteryExistance, serialNumber);
		this.ramExisting = ramExisting;
	}
	
	public SmartCalculator() {
		
	}
	
	public SmartCalculator clone() {
		SmartCalculator x = new SmartCalculator();
		x.calcProc = calcProc;
		x.solarBatteryExistance = solarBatteryExistance;
		x.serialNumber = serialNumber;
		x.ramExisting = ramExisting;
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
		
		if (ramExisting) {
			q += q + 1.5 * q - 0.1 * q;
		} 
		else {
			q += q * 1.2 - 1.1 * q;
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
	
	public int factorial (int x) {
		int q = 1;
		for (int i = 2; i <= x; i++) {
			q *= i;
		}
		return q;
	}
	
}