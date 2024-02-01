package studio2;
import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the amount of money you start with: ");
    double startAmount = scan.nextDouble();
    System.out.println("Enter the win probability: ");
    double winChance = scan.nextDouble();
    System.out.println("Enter the winning limit: ");
    double winLimit = scan.nextDouble();
    System.out.println("Enter the number of days: ");
    int totalSimulations = scan.nextInt();  
    int numberSimulations = 0;
    double ruin;
    double a = (1-winChance)/winChance;
    String success = "failure";
    int losses = 0;
     for(int i = 0; i<totalSimulations;i++){
    	 while(startAmount < winLimit && (startAmount>0)) {
    	    	if(Math.random()<=winChance) {
    	    		startAmount++;
    	    	}
    	    	else {
    	       startAmount--;
    	    }
    	    	numberSimulations++;
    	    	if(startAmount <= winLimit && (startAmount>0)) {
    	    		 success = "success";
    	    	}
    	    	else {
    	    		losses++;
    	    	}
    		}
    	  success = "failure";
	    	System.out.println("This is simulation " + (i+1) + " and " + numberSimulations + " plays occurred today and the day ended in " + success + ".");   	
     }
     if(winChance == 0.5) {
    	 ruin = 1 - startAmount/winLimit;
     }
     else {
    	 ruin = ((Math.pow(a,startAmount)-Math.pow(a,winLimit))/(1-Math.pow(a,winLimit)));
     }
     System.out.println("Losses: " + losses + " Simulations: " + totalSimulations);
     System.out.println("Ruin Rate from Simulation: " + (losses/totalSimulations) + " Expected Ruin Rate: " + ruin);
     
    }
}
