import java.util.InputMismatchException;
import java.util.Scanner;

public class ID30324078 {
	public static Scanner menuInput;
	
	public static Event hurdles100m;
	public static Event freestyle400m;
	public static Event diving10m;
	public static Event discus;
	
	public static University fedUni;
	public static University deakinUni;
	public static University latrobeUni;
	public static University monashUni;
	
	public static Participant part1;
	public static Participant part2;
	public static Participant part3;
	public static Participant part4;
	public static Participant part5;
	public static Participant part6;
	public static Participant part7;
	public static Participant part8;
	
	public static void printBanner(String initBanner){
		String banner = initBanner;
		
		for(int i=0; i < (banner.length()*1.5); i++){
			System.out.print("=");
		}
		System.out.println("\n\n" + banner + "\n");
		
		for(int i=0; i < (banner.length()*1.5); i++){
			System.out.print("=");
		}
		System.out.println("");
	}

	public static void initialize(){
		System.out.println("\nInitializing Events...");
		
		hurdles100m = new Event("100m Hurdles", 8, 2, 12.20, false);
		freestyle400m = new Event("400m Freestyle", 8, 2, 3.56, false);
		diving10m = new Event("10m Diving", 4, 1, 112.10, true);
		discus = new Event("Discus", 4, 1, 69.89, true);
		
		System.out.println("Events Registered");
		
		fedUni = new University("Federation University Australia");
		deakinUni = new University("Deakin University");
		latrobeUni = new University("Latrobe University");
		monashUni = new University("Monash University");
		
		part1 = new Participant("Omer Javed", fedUni);
		part2 = new Participant("Elliot Alderson", fedUni);
		part3 = new Participant("Darlene", deakinUni);
		part4 = new Participant("Angela Moss", deakinUni);
		part5 = new Participant("Tyrell Wellick", latrobeUni);
		part6 = new Participant("Phillip Price", latrobeUni);
		part7 = new Participant("Gideon Goddard", monashUni);
		part8 = new Participant("Dominique DiPierro", monashUni);
		
		System.out.println("Participants Created");
			
		hurdles100m.registerCompititor(part1);
		hurdles100m.registerCompititor(part2);
		hurdles100m.registerCompititor(part3);
		hurdles100m.registerCompititor(part4);
		hurdles100m.registerCompititor(part5);
		hurdles100m.registerCompititor(part6);
		hurdles100m.registerCompititor(part7);
		hurdles100m.registerCompititor(part8);
		
		freestyle400m.registerCompititor(part1);
		freestyle400m.registerCompititor(part2);
		freestyle400m.registerCompititor(part3);
		freestyle400m.registerCompititor(part4);
		freestyle400m.registerCompititor(part5);
		freestyle400m.registerCompititor(part6);
		freestyle400m.registerCompititor(part7);
		freestyle400m.registerCompititor(part8);
		
		diving10m.registerCompititor(part1);
		//diving10m.registerCompititor(part2);
		diving10m.registerCompititor(part3);
		diving10m.registerCompititor(part5);
		diving10m.registerCompititor(part7);
		
		
		discus.registerCompititor(part2);
		discus.registerCompititor(part4);
		discus.registerCompititor(part6);
		discus.registerCompititor(part8);
		
		
		System.out.println("Initialization complete");
	}
	
	
	
	public static void mainMenu(){
		printBanner("Fed Uni Olympics Management System Menu");			
		System.out.println("Please select an option from the menu: ");
		System.out.println("1. Enter results");
		System.out.println("2. View reports");
		System.out.println("3. View program credits");
		System.out.println("4. Exit program");
		
		menuInput = new Scanner(System.in);
		int option = 0;
		try{
			option = menuInput.nextInt();
		}catch(InputMismatchException e){
			System.out.println("Invalid option selected, Please try again\n");
			mainMenu();
		}
			
		if(option == 1){
			enterResults();
		}
		else if(option == 2){
			viewReports();
		}
		else if(option == 3){
			printCredits();
		}
		else if(option == 4){
			exit();
		}
		else{
			System.out.println("Invalid option selected, Please select 1,2 or 3\n");
			mainMenu();
		}
			
	}
	
	public static void enterResults(){
		printBanner("Enter Results                  ");
		System.out.println("Please select the event: ");
		System.out.println("1. 100m Hurdles");
		System.out.println("2. 400m Freestyle");
		System.out.println("3. 10 Diving");
		System.out.println("4. Discus");
		System.out.println("5. Return to main menu");
		
		menuInput = new Scanner(System.in);
		int option = 0;
		try{
			option = menuInput.nextInt();
		}catch(InputMismatchException e){
			System.out.println("Invalid option selected, Please try again\n");
			mainMenu();
		}	
		if(option == 1){
			hurdles100m.eventResults();
			enterResults();
		}
		else if(option == 2){
			freestyle400m.eventResults();
			enterResults();
		}
		else if(option == 3){
			diving10m.eventResults();
			enterResults();
		}
		else if(option == 4){
			discus.eventResults();
			enterResults();
		}
		else if(option == 5){
			mainMenu();
		}
		else{
			System.out.println("Invalid option selected, Please select 1,2 or 3\n");
			mainMenu();
		}
	}
	
	public static void viewReports(){
		printBanner("View Reports                   ");
		System.out.println("Please select the event: ");
		System.out.println("1. 100m Hurdles");
		System.out.println("2. 400m Freestyle");
		System.out.println("3. 10 Diving");
		System.out.println("4. Discus");
		System.out.println("5. New records set");
		System.out.println("6. Return to main menu");
		
		menuInput = new Scanner(System.in);
		int option = 0;
		try{
			option = menuInput.nextInt();
		}catch(InputMismatchException e){
			System.out.println("Invalid option selected, Please try again\n");
			mainMenu();
		}	
		if(option == 1){
			hurdles100m.viewResults();
			viewReports();
		}
		else if(option == 2){
			freestyle400m.viewResults();
			viewReports();
		}
		else if(option == 3){
			diving10m.viewResults();
			viewReports();
		}
		else if(option == 4){
			discus.viewResults();
			viewReports();
		}
		else if(option == 5){
			for(int i=0;i<100;i++){
				System.out.print("**");
			}
			System.out.println();
			System.out.println("New records set at federation University Olympic Games:\n\t100m Hurdles: " + hurdles100m.checkForRecords() 
					+ "\n\t400m Freestyle: " + freestyle400m.checkForRecords()
					+ "\n\t10m Diving: " + diving10m.checkForRecords()
					+ "\n\tDiscus: " + discus.checkForRecords());
			for(int i=0;i<100;i++){
				System.out.print("**");
			}
			System.out.println();
			viewReports();
		}
		else if(option == 6){
			mainMenu();
		}
		else{
			System.out.println("Invalid option selected, Please select 1,2 or 3\n");
			mainMenu();
		}
	}
	
	public static void printCredits(){
		for(int i=0; i < 50; i++){
			System.out.print("=");
		}
		System.out.println("\nProgram Credits\n");
		System.out.println("This program was developed by:\n");
		System.out.println("\tOmer Javed, student ID 30324078\n");
		System.out.println("For ITECH1000 Programming 1 Semester 2 2016\n");
		for(int i=0; i < 50; i++){
			System.out.print("=");
		}
	}

	public static void exit(){
		menuInput.close();
		System.out.println("Thankyou for using Federation University Event Management System");
		System.exit(0);
	}
	
	
	public static void main(String[] args) {
		printBanner("Fed Uni Olympics Management System");
		initialize();
		mainMenu();
		
	
		
	}

}
