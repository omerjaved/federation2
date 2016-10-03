
public class Result {
	private Participant compititor;
	private double result;
	
	public Result(Participant initParticipant){
		compititor = initParticipant;
	}
	
	public void setResult(double initResult){
		result =  initResult;
	}
	
	public double getResult(){
		return result;
	}

	public Participant getCompititor(){
		return this.compititor;
	}
	
	public String toString(){
		return result + ":\t" + compititor.getName();
	}
}
