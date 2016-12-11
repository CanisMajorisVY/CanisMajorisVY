public class Bonobo {
	
	protected int mass = 0;
	protected boolean socialActivity = false;
	protected String bodyColor = "-";
	
	public Bonobo (int mass, boolean socialActivity, String bodyColor){
		this.mass = mass;
		this.socialActivity = socialActivity;
		this.bodyColor = bodyColor;
	}
	
	public Bonobo () {
		
	}
	
	public Bonobo clone() {
		Bonobo x = new Bonobo();
		x.mass = mass;
		x.socialActivity = socialActivity;
		x.bodyColor = bodyColor;
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
		
		return q;
	} 
	
	public boolean equals (Object x1) {
		if (x1 == null) return false;
		Bonobo x = (Bonobo) x1;
		if (hashCode() == x.hashCode()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public String toString() {
		return "mass = " + mass;
	}
	
	public boolean equals (Human b) {
		if (mass == b.mass) {
			if (socialActivity == b.socialActivity) {
				if (bodyColor == b.bodyColor) {
					return true;
				} 
			}
		}
		return false;
	}
	
	public void setMass (int mass) {
		this.mass = mass;
	}
	
	public int getMass () {
		return mass;
	}
	
	public void setSocialActivity (boolean socialActivity) {
		this.socialActivity = socialActivity;
	}
	
	public boolean getSocialActivity () {
		return socialActivity;
	}
	
	public void setBodyColor (String bodyColor) {
		this.bodyColor = bodyColor;
	}
	
	public String getBodyColor () {
		return bodyColor;
	}
	
	public String saySomething() {
		return "hu hu hu aaa hu";
	}
	
	public String playWithCongerer (int numberOfCongerers) {
		if (numberOfCongerers < 2) {
			return "a a a huhuhu";
		}
		else {
			return "HAHAHA huhuhu";
		}
	}
	
	public String lookAround(boolean somebodyIsAround) {
		if (somebodyIsAround) {
			return "a a a huhuhu";
		}
		else {
			return "mhm...";
		}
	}
	
} 