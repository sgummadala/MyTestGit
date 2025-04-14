package com.cvs.pos;

import java.util.Scanner;

public class Palindrome {

	public static boolean isPalindrome(String s){
		
		int i = 0;
		int j = s.length()-1 ;
		
		while ( i < j ) {
		    if (s.charAt(i) != s.charAt(j)) {
                return false;      
            }
            i++;
            j--;
		}
		return true ;
	}
	
	
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the String to check for palindrome :");
		String s1 = scanner.next();
		System.out.println(s1);
		 s1 = s1.toLowerCase();
		 scanner.close();

	        // Check and print results for s1
	        if (isPalindrome(s1)) {
	            System.out.println("\"" + s1 + "\" is a palindrome.");
	        } else {
	            System.out.println("\"" + s1 + "\" is not a palindrome.");
	        }
	
	
	}
}
