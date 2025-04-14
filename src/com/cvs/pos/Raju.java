package com.cvs.pos;
import java.util.Scanner;  

public class Raju {
	
	static int varInt1 = 5 ;
	char varCh1 = 'R' ;
	char myLetter = 'D';
	boolean varB1 ;
	String varStr1 ="Raju" ;
	String[] cars ;
	int[] myNum ; 
	int myNums[] ; 
	int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
	byte a ; 
	
	//int myNumbers[4][3] = {1,2,3,4,5,6,7,8,9,10,11,12 };
	int arr[][] = {{0,1,2,3},{5,6,7}};
	
	public static void main(String[] args) { 
		
		Raju objRaj = new Raju();
		int varInt2 = 10 ;
		int varInt3 ;
		//System.out.println(varInt1) ;
		//System.out.println(varInt2) ;
		objRaj.methodR(); 
	}
		
	public void methodR() { 
	
		
		    int varInt2 = 10 ;
			int varInt3 ;
			
			String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
			int[] myNum = {10, 20, 30, 40};
			
			System.out.println(varInt1) ;
			System.out.println(varInt2) ;
			//System.out.println(varInt3) ;
			
		for (int i = 0; i < cars.length; i++) {
			System.out.println(cars[i]) ;
	     	}
	//For each loop syntax
		for (int i : myNum) {
			  System.out.println(i);
		 	}
		System.out.println(myNumbers[1][2]);
		
		
		for (int i = 0; i < myNumbers.length; ++i) {
		      for(int j = 0; j < myNumbers[i].length; ++j) {
		    	  
		    	  System.out.println("Array Position  : " + "(" +(i) + ","+(j) +")" + " -- " + "Array Value : " + myNumbers[i][j]);
		    	 
		    	  // System.out.println("Print first array : " + (j));
		    	 //System.out.println("Value of array table  : " + myNumbers[i][j]);
		    	// two dimensional arrays  (int arr[][] = {{0,1,2,3},{5,6,7}};) - 2 arrays independet  first array = 0 and second array = 1
		    	// this is just 2 different arrays -- first array = 0 second array = 1 so array postion (0,0) means --> (array-number=0 , array-value at index 0)
		    	// this is just 2 arrays first arry = 0 second array = 1 so array postion (1,2) means --> (array-number=1 , array-value at index 2)
		    	// you can create 2D array - in which number of rows will be product of rows each in arrays for.e.g arr[2][3] will have 6 possible values
		    	  // this will be in table format ?? need clarification on this
		      }
		    }
	
	//new 2D array table format	
		
	    int[][] arr = new int[3][3];  
	    Scanner sc = new Scanner(System.in);  
	    for (int i =0;i<3;i++)  
	    {  
	        for(int j=0;j<3;j++)  
	        {  
	            System.out.print("Enter Element : ");  
	            arr[i][j]=sc.nextInt();  
	            System.out.println();  
	        }  
	    }  
	    System.out.println("Printing Elements... : ");  
	    for(int i=0;i<3;i++)  
	    {   
	        System.out.println();
	        for(int j=0;j<3;j++)  
	        {  
	            System.out.print(arr[i][j]+"\t" );  
	        }  
	    }
	
	  //
	    System.out.println();
	    System.out.println();
	    System.out.println("Printing Elements with subtraction and concat... : "); 
	       
	    for(int i=0;i<3;i++)  
	    {   
	        System.out.println();  
	        for(int j=0;j<3;j++)  
	        {  
	            System.out.print( (arr[i][j] -1) +"\t" + " ");  
	          
	        }  
	    }
	 
	//
	}

}