import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Event {
	private String name;
	private int MAX_COMPITITORS;
	private double currentGamesRecord;
	private int maxUniParticipants;
	private boolean highToLowScoring;
	private Result[] results;
	private int registryIndex = 0;	//Assumption to handle the limitation of participants
	private int uniPartIndex = 0;
	private Scanner menuInput;
	
	public Event(String initName,int initMaxComp,int initMaxParticipants,double initGamesRecord,boolean initHighToLow){
		name = initName;
		MAX_COMPITITORS = initMaxComp;
		maxUniParticipants = initMaxParticipants;
		currentGamesRecord = initGamesRecord;
		highToLowScoring = initHighToLow;
		results = new Result[MAX_COMPITITORS];
	}
	
	String getEventName(){
		return name;
	}
	
	int getCompitatorLimit(){
		return MAX_COMPITITORS;
	}
	
	double getGamesRecord(){
		return currentGamesRecord;
	}
	
	void registerCompititor(Participant initParticipant){
		
		if(registryIndex<MAX_COMPITITORS){
			//if(universityAtLimit() == false){		
					Result participantResult = new Result(initParticipant);
					results[registryIndex] = participantResult;
					System.out.println("Registration Successful for " + initParticipant.getName() + " in " + getEventName());
					registryIndex++;
					uniPartIndex++;
			//}
			//else
			//	System.out.println("Unable to registration " + initParticipant.getName() + " to event " + getEventName() + " university limit reached");
		}
		else{
			System.out.println("Unable to register "+ initParticipant.getName() + " to event "+ getEventName() +" maximum number of participants reached");		
		}
	}
	

	private boolean universityAtLimit(){
		return uniPartIndex > maxUniParticipants;
	}

	void eventResults(){
		for (int k=0; k < results.length ; k++){
			System.out.println("Enter result for " + results[k].getCompititor().getName());
			menuInput = new Scanner(System.in);
			double option = 0;
			try{
				option = menuInput.nextDouble();
			}catch(InputMismatchException e){
				System.out.println("Invalid option selected, Please try again\n");
			}
			Result newResult = new Result(results[k].getCompititor());
			newResult.setResult(option);
			results[k] = newResult;
			if(highToLowScoring){
				if(newResult.getResult() > currentGamesRecord){
					currentGamesRecord = newResult.getResult();
				}
			}
			else{
				if(newResult.getResult() < currentGamesRecord){
					currentGamesRecord = newResult.getResult();
				}
			}
			
		}
		System.out.println("Results entry completed!\n");
	}
	
	void viewResults(){
		for (int i=0; i<=40; i++){
			System.out.print("=");
		}
		System.out.println("\nResults for "+ this.getEventName());
		for (int i=0; i<=40; i++){
			System.out.print("=");
		}
		System.out.println("");
		for(int j=0; j < results.length ; j++){
			System.out.println(results[j].toString());
		}
		
		//Medalist code goes here
		double[] dResults = new double[results.length];
		for(int i=0; i < results.length ; i++){
			dResults[i] = results[i].getResult();
		}
		double[] sortedResults = (double[])dResults.clone(); 
		Arrays.sort(sortedResults);
		int[] medalistsIndex = new int[3];
		if (highToLowScoring == true){
			for(int i=0; i< 3 ; i++){
				medalistsIndex[i] = getIndex(dResults,sortedResults[dResults.length-(i+1)]);
			}
			
		}
		else{
			for(int i=0; i< 3 ; i++){
				medalistsIndex[i] = getIndex(dResults,sortedResults[(i)]);
			}
			currentGamesRecord = dResults[medalistsIndex[0]];
		}
		//currentGamesRecord = dResults[medalistsIndex[0]];
		System.out.println("--- Medallists ---\nGold:\t" + results[medalistsIndex[0]] + "\nSilver:\t" + results[medalistsIndex[1]] + "\nBronze:\t" + results[medalistsIndex[2]]);
		/*
		*/
		
		
	}
	
	private static int getIndex(double[] paramValue, double v){
		int temp = 0;
		for(int i=0; i< paramValue.length; i++){
			if(paramValue[i]==v){
				temp = i;
				break;
			}
		}
		return temp;
	}
	
	String checkForRecords(){
		//double newRecord = 0.0;
		return "Current Games Record = " + currentGamesRecord;
	}
	
}

