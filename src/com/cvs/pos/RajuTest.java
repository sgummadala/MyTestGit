package com.cvs.pos;

import java.util.Arrays;

public class RajuTest {

	int varNum = 10;
	char varChar = 'V' ;
	String strChar = "HelloWorld" ;
	byte bytVal = '2' ; //byte stores numbers but in strig converes into ascii value
	byte myNum = 1;
	
	public static void main(String[] args) {
		RajuTest objRT = new RajuTest();
		objRT.show();	
	}
	
	static {
		System.out.println(1);
	}
	
	
	public void show(){
		
		
		
		String[] cars = {"BMV", "volvo", "Audi"};
		int[] myNums = {20,12,14,15} ;
		
		
		System.out.println( varNum + varChar + strChar + bytVal ); // since adding char converts to its ascii value and add
		System.out.println( varChar );
		System.out.println( strChar );
		System.out.println( bytVal );
		System.out.println( myNum );
		System.out.println( varNum );
		
		System.out.println(Arrays.toString(cars));
		
		//print array
		for (int i = 0; i<cars.length ; ++i) {
			System.out.println(cars[i]) ;
			System.out.print(cars[i]) ;
		}
			
			
			
	}

}
