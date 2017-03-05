public class Human extends Bonobo {
	
	protected int iq = 0;
	protected int mood = 0; 
	
	public Human (int mass, boolean socialActivity, String bodyColor, int iq, int mood) {
		super(mass, socialActivity, bodyColor);
		this.iq = iq;
		this.mood = mood;
	}
	
	public Human () {
		
	}
	
	public Human clone() {
		Human x = new Human();
		x.mass = mass;
		x.socialActivity = socialActivity;
		x.bodyColor = bodyColor;
		x.iq = iq;
		x.mood = mood;
		return x;
	}
	
	public int hashCode() {
		int q = 123456;
		q += q + mass * q / 2;
		if (socialActivity) {
			q += 134;
		}
		else {
			q += q * 2;
		}
		
		for (int i = 0; i < bodyColor.length(); i++){
			q +=  bodyColor.charAt(i) * 3 / 2;
		}
	
		q += iq - iq / 2 + q / 3* 11;
		q += mood * 12 / 5;
		return q;
	} 
	
	public boolean equals (Human x) {
		if (hashCode() == x.hashCode()) {
			return true;
		}
		else {
			return false;
		}
	}
	 
	public String toString() {
		return "IQ = " + iq;
	}
	
	public String playWithCongerer (int numberOfCongerers) {
		if (numberOfCongerers > 1) {
			return "Hello";
		}
		else {
			return "lalala";
		}
	}
	
	public String lookAround(boolean somebodyIsAround) {	
			return "mhm...";
	}
	
	public void setmood(int mood) {
		this.mood = mood;
	}
	
	public void setIq(int iq) {
		this.iq = iq;
	}
	
	public int getIq() {
		return iq;
	}
	
	public int getMood() {
		return mood;
	}
	
	public void makeSomethingInteresting() {
		iq++;
		mood++;
	}
	
	public void makeSomethingStupid() {
		mood += 2;
		iq--;
	}
	
}