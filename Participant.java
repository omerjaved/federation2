
public class Participant {
	private String name;
	private University enrolledUniversity;
	
	public Participant(String initName ,University initUni){
		name = initName;
		enrolledUniversity = initUni;
	}
	
	public String getName(){
		return name;
	}

	public University getEnrolledUniversity() {
		return enrolledUniversity;
	}
	
	

}
