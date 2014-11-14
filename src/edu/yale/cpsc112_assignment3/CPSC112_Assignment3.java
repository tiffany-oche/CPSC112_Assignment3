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

