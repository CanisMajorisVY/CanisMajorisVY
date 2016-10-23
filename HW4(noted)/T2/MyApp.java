public class MyApp {
	
	public static void main (String[] args) {
		
		Faculty itis = new Faculty("ITIS");
		Group g1 = new Group("11 - 604");
		g1.setStdQuantity(19);
		
		Student misha = new Student("Misha");
		misha.setGroup(g1);
		misha.getGroup().setFaculty(itis);
		//...
			
		System.out.println("Name: " + misha.getName());
		System.out.println("Group name: " + misha.getGroup().getGroupName());
		System.out.println("Group quantity is: " + misha.getGroup().getStdQuantity());
		System.out.println("Faculty is: " + misha.getGroup().getFaculty().getFName());
		
	
	}
	
}