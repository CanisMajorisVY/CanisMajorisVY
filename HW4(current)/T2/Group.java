class Group {
	
	String name;
	Faculty f;
	int q;
	
	Group (String x) {
		name = x;
	}
	
	void setGroupName (String x) {
		name = x;
	}
	
	String getGroupName () {
		return name;
	}
	
	void setStdQuantity(int x) {
		q = x;
	}
	
	int getStdQuantity() {
		return q;
	}

	void setFaculty(Faculty x) {
		f = x;
	}
	
	Faculty getFaculty() {
		return f;
	}

}