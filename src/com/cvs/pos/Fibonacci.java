package com.cvs.pos;

import java.util.Scanner;

public class Fibonacci {
	
	public static void printFibo(int n){
		int first = 0, second = 1;

        System.out.print("Fibonacci Series: " + first + " , " + second);

        for (int i = 2; i < n; i++) {
            int next = first + second;
            System.out.print(" , " + next);
            first = second;
            second = next;
        }
        System.out.println();
    
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of terms to print : ") ;
		int number = scanner.nextInt();
		System.out.println("Numbers of fibonacci terms to print : " + number) ;
		scanner.close();
		System.out.println();
		printFibo(number);
		
	}

}
