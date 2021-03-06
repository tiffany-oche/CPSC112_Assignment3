package edu.yale.cpsc112_assignment3;

import java.util.Random;

public class CPSC112_Assignment3 {

  public static String mySecret = "";
  public static boolean DEBUG = true;
  public static Random r = new Random();

  public static void main(String[] args) {
    makeMySecret();
    isGameOver("1234");
    isGameOver("4321");
    isGameOver("2567");
    isGameOver("1432");
  }

	public static void remakeMySecret() {

		int n1=r.nextInt(7) + 1;
		int n2=r.nextInt(7) + 1;
		int n3=r.nextInt(7) + 1;
		int n4=r.nextInt(7) + 1;

		if (n1!=n2&&n2!=n3&&n3!=n4&&n4!=n1&&n2!=n4&&n3!=n1){
			mySecret=(n1+""+n2+""+n3+""+n4);
			//System.out.print(n1+""+n2+""+n3+""+n4);
		}

		else{
			remakeMySecret();
		}
	}

	public static void makeMySecret() {

		int n1=r.nextInt(7) + 1;
		int n2=r.nextInt(7) + 1;
		int n3=r.nextInt(7) + 1;
		int n4=r.nextInt(7) + 1;

		if (n1!=n2&&n2!=n3&&n3!=n4&&n4!=n1&&n2!=n4&&n3!=n1){
			mySecret=(n1+""+n2+""+n3+""+n4);
		}

		else{
			remakeMySecret();
		}
		// Part 1 code goes here (please leave the next few lines at the end of the makeMySecret method)
		if (DEBUG) {
			System.out.println(mySecret);
		}
	}

	//-----------------------------------------------------------------------------------------

	public static boolean isGuessValid(String input) {
		int inputLength=input.length();

		if (inputLength!=4){
			System.out.print("Input must be a 4-digit number with digits between 1 and 7.");
			return false;
		}
		for(int i=0;i<4;i++){

			if (input.charAt(i)!='7'&&input.charAt(i)!='6'&&input.charAt(i)!='5'&&input.charAt(i)!='4'&&input.charAt(i)!='3'&&input.charAt(i)!='2'&&input.charAt(i)!='1'){
				System.out.println("Input must be a 4-digit number with digits between 1 and 7.");
				return false;
			}

			for(int j=i+1; j<inputLength; j++){

				if(input.charAt(i)==input.charAt(j)){
					System.out.print("Input must be a 4-digit number with digits between 1 and 7.");
					return false;
				}
			}

		}
		return true;
	}

	//-----------------------------------------------------------------------------------------
	public static boolean isGameOver(String input) {
		// Parts 3 and 4 code goes here
		int numberCorrect=0;
		int numberPresent=0;
		boolean w=isGuessValid(input);
		if (w==false){
			return false;

		}

		 if(Integer.parseInt(input)>highestGuess){
			highestGuess=Integer.parseInt(input);
			//System.out.println(highestGuess);
			//System.out.println(exceptions);
			//exceptions=exceptions-1;
			
			if (exceptions<=0&&Integer.parseInt(mySecret)<Integer.parseInt(input)){
				return false;
			}

		}
		for(int k=0; k<4; k++){

			if (mySecret.charAt(k)==input.charAt(k)){
				numberCorrect++;
			}
			for(int l=0;l<4;l++){
				if (mySecret.charAt(k)==input.charAt(l)){
					numberPresent++;
				}
				
			}
			
		}
		if (Integer.parseInt(input)<highestGuess){
			exceptions=exceptions-1;
		System.out.println("Your guess was lower than allowed. You have "+exceptions+ " exceptions remaining."); 
		}
		if(numberPresent==4&&numberCorrect==4){
			System.out.println("You won!");
			return true;
		}

		if(numberPresent<4||numberCorrect<4){
			System.out.println(numberPresent+","+numberCorrect);
			return false;
		}

		return true;


	}
	
}



