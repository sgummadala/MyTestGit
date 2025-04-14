package com.cvs.pos;

public class MyOwnClass {
	
	static int x = 1 ;
	int y = 2 ;
	
	public static void main(String[] args) {
		MyOwnClass objMyOwnClass = new MyOwnClass();
		System.out.println("hello" + x);
		System.out.println("hello" + objMyOwnClass.y);
		
		if (x > objMyOwnClass.y ) 
			System.out.println( "true");
			
		else if 	(objMyOwnClass.y > x )
			System.out.println( "false");
	
		switch (x) {
	    case 1:
	    	System.out.println( "Case 1");
	        break;
	    case 2:
	    	System.out.println( "Case 2");
	        break;
	    // ... more cases as needed ...
	    default:
	    	System.out.println( "Default");
	}
	
	}

}
