public class SmallOrbitalStation {	

	protected int fuelTankCapacity = 100;
	protected int numberOfHumansOnBoard = 0;
	protected boolean engineIsLaunched = false;
	protected int fuel = 100;
	protected int serialNumber = 0;
	
	public SmallOrbitalStation () {
		
	}
	
	public SmallOrbitalStation(int fuelTankCapacity, int numberOfHumansOnBoard, boolean engineIsLaunched, int serialNumber) {
		this.fuelTankCapacity = fuelTankCapacity;
		this.numberOfHumansOnBoard = numberOfHumansOnBoard;
		this.engineIsLaunched = engineIsLaunched;
		this.serialNumber = serialNumber;
	}
	
	public String toString() {
		return "Serial Number of Ship is: " + serialNumber;
	}
	
	public SmallOrbitalStation clone() {
		SmallOrbitalStation s = new SmallOrbitalStation();
		s.fuelTankCapacity = fuelTankCapacity;
		s.numberOfHumansOnBoard = numberOfHumansOnBoard;
		s.engineIsLaunched = engineIsLaunched;
		s.fuel = fuel;
		s.serialNumber = serialNumber;
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
		return q;
	}
	
	public boolean equals(SmallOrbitalStation x) {
		if (hashCode() == x.hashCode()) {
			return true;
		} 
		else {
			return false;
		}
	}
	
	public void fillTank() {
		fuel += 100;
	}
	
	public void letPeopleInside(int x) {
		numberOfHumansOnBoard += x;
	}
	
	public int howMuchPeopleInside() {
		return numberOfHumansOnBoard;
	}
	
	public int showBalanceOfFuel() {
		return fuel;
	}
	
	public void turnEngineOn() {
		engineIsLaunched = true;
	}
	
	public void turnEngineOff() {
		engineIsLaunched = false;
	}
	
} 