package com.cvs.pos;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.*;

public class DemoJava {
	 public static void main(String[] args) { 
		 System.out.println("Hello Raj");
	 
		 
		 
		 ArrayList<Integer> al1 = new ArrayList<>();
		 
		 al1.add(12);
		byte[] decodedBytes = Base64.getDecoder().decode("encodedUserPassword");
		 
		 //byte[] decodedBytes = Base64.getDecoder().decode("Sriram");
		 
	//	 byte[] decodedBytes = Base64.getDecoder().decode("[B@15db9742"); 
	 System.out.println(decodedBytes);
	 
		 System.out.println(al1);
		 
		 byte[] decodedByes = Base64.getEncoder().encode(decodedBytes);
				 
		 System.out.println(decodedByes);
		 // getDecoder().decode("encodedUserPassword");
		 
		 Decoder decodedBytes1 = Base64.getDecoder();				 
				 //.decode("encodedUserPassword");
		 System.out.println(decodedBytes1);
		 
		 
		// byte[] decodedByes1 = Base64.decode(decodedBytes1);
	 }
}