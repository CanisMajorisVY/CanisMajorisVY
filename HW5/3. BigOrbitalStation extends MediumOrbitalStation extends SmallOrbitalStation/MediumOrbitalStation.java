public class MediumOrbitalStation extends SmallOrbitalStation {
	
	protected boolean telescopeAvailability = false;
	
	MediumOrbitalStation (int fuelTankCapacity, int numberOfHumansOnBoard, boolean engineIsLaunched, int serialNumber, boolean telescopeAvailability) {
		super(fuelTankCapacity,  numberOfHumansOnBoard, engineIsLaunched,  serialNumber);
		this.telescopeAvailability = telescopeAvailability;
	}
	
	MediumOrbitalStation () {
		
	}
	
	public MediumOrbitalStation clone() {
		MediumOrbitalStation s = new MediumOrbitalStation();
		s.fuelTankCapacity = fuelTankCapacity;
		s.numberOfHumansOnBoard = numberOfHumansOnBoard;
		s.engineIsLaunched = engineIsLaunched;
		s.fuel = fuel;
		s.serialNumber = serialNumber;
		s.telescopeAvailability = telescopeAvailability;
		return s;
	}
	
	public int hashCode () {
		int q = 12345;
		q += fuelTankCapacity * 11;
		q += numberOfHumansOnBoard * 12 / 5 - numberOfHumansOnBoard * 1/3;
		
		if (engineIsLaunched) {
			q += 345 + fuelTankCapacity;
		}
		else {
			q += 234 - fuelTankCapacity % 100;
		}
		
		q += q * fuel;
		
		q += serialNumber * 3/2;
		if (telescopeAvailability) {
			q += 1222;
		}
		else {
			q += 10030;
		}
		
		return q;
	}
	
	public boolean equals(MediumOrbitalStation x) {
		if (hashCode() == x.hashCode()) {
			return true;
		} 
		else {
			return false;
		}
	}
	
	public boolean checkIfViewIsGood(boolean someInterestingAround) {
		if (someInterestingAround && telescopeAvailability) {
			return true;
		}
		else {
			return false;
		}
	}
	
}