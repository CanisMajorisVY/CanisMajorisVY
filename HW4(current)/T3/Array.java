class Array {
	
	int j = 0;
	Point[] ar = new Point[];
	
	void lengthOptimizer(int l) {
			
		Point[] nAr = new Point[ar.length];
		
		for (int i = 0; i < ar.length; i++) {
			nAr[i] = ar[i];
		}
		
		ar = new Point[l * 2];
		
		for (int i = 0; i < nAr.length; i++) {
			ar[i] = nAr[i];
		}	
		
	}
	
	void addPoint(Point p) {
		
		if (j >= ar.length) {
			lengthOptimizer(j);
		}
		
		ar[j] = p;
		j++;
		
	}
	
	void removePoint(int numb) {
		
		ar[numb] = null;
		
	}
	
	
	Point getPoint(int numb) {
		
		return ar[numb];
		
	}
	
}