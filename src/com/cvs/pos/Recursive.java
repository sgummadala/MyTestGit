package com.cvs.pos;

import java.util.Scanner;

public class Recursive {
	
		public static void main(String[] args) {
			
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("Enter an integer: ");
	    int number = scanner.nextInt();
		int result = sum(number) ;
		System.out.println("Sum of numbers : " + result);
		scanner.close();
	}

	public static int sum(int k){
			
		if ( k > 0 ) {
			System.out.println("Sum of numbers : " + k);
			return k + sum(k-1) ;
			//10 + sum(9)
			//10 + 9 + sum(8)+ ....
			//10 + 9 +....+1+sum(0)
		}
		else {
			return 0;
		}
	}
}
