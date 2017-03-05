public class BigOrbitalStation extends MediumOrbitalStation{
	
	protected boolean ftlEngineExisting = false;
	
	public BigOrbitalStation (int fuelTankCapacity, int numberOfHumansOnBoard, boolean engineIsLaunched, int serialNumber, boolean telescopeAvailability, boolean ftlEngineExisting) {
		super (fuelTankCapacity, numberOfHumansOnBoard, engineIsLaunched, serialNumber, telescopeAvailability);
		this.ftlEngineExisting = ftlEngineExisting;
	}
	
	public BigOrbitalStation () {
		
	}
	
	public BigOrbitalStation clone() {
		BigOrbitalStation s = new BigOrbitalStation();
		s.fuelTankCapacity = fuelTankCapacity;
		s.numberOfHumansOnBoard = numberOfHumansOnBoard;
		s.engineIsLaunched = engineIsLaunched;
		s.fuel = fuel;
		s.serialNumber = serialNumber;
		s.telescopeAvailability = telescopeAvailability;
		s.ftlEngineExisting = ftlEngineExisting;
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
		
		if (ftlEngineExisting) {
			q += 12234;
		}
		else {
			q += 1012354;
		}
		
		return q;
	}
	
	public boolean equals(BigOrbitalStation x) {
		if (hashCode() == x.hashCode()) {
			return true;
		} 
		else {
			return false;
		}
	}
	
	public String StartFtlEngine () {
		if (ftlEngineExisting) {
			return "through the universe!!!";
		} 
		else {
			return "psssss....";
		}
	}
	
}