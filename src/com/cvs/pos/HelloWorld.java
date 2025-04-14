package com.cvs.pos;

import java.io.File;
import java.util.Scanner;

public class HelloWorld {
	 public static void main(String[] args) { 
		 
		 File file = new File("C:/Java/Data/Data.txt");
		 Scanner scanner = new Scanner(System.in);
		 //String readText = scanner.toString() ;
		 //int number = scanner.nextInt();
		 
		 

	        System.out.print("Enter your name: ");
	        String name = scanner.nextLine();
	        System.out.println("Your name is: " + name);

	        System.out.print("Enter your age: ");
	        int age = scanner.nextInt();
	        System.out.println("Your age is: " + age);

		 System.out.println("Hello Raj " + file + " :" + name + " "+age);
		 scanner.close();
	 }
}