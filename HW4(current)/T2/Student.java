class Student {

	String name;
	Group g;
	int age = 0;
	int bestNote = 0;
	boolean starvation = false;
	boolean hwDone = false;

	Student (String n) {
		name = n;
	}

	Student () {

	}

//--------------------------------------------------------------

	boolean checkHunger () {
		if (starvation) {
			return true;
		}
		else {
			return false;
		}
	}

	void eatSomething() {
		if (starvation) {
			starvation = false;
		}
	}

	boolean checkHomeWorkDone() {
		hwDone = false;
		return false;
		//Homework never can be done
	}

	void makeHomeWork() {
		if (!hwDone) {
			hwDone = true;
		}
	}

	void makeThatYouWant() {
		if (age >= 18) {
			eatSomething();
		}
		else {
			makeHomeWork();
		}
	} 


//--------------------------------------------------------------

	void setName(String x) {
		name = x;
	}

	String getName() {
		return name;
	}

	void setAge(int x) {
		age = x;
	}

	int getAge() {
		return age;
	}

	void setBestNote(int x) {
		bestNote = x;
	}

	int getBestNote() {
		return bestNote;
	}


//--------------------------------------------------------------

	void setGroup(Group x) {
		g = x;
	}

	Group getGroup() {
		return g;
	}


}

