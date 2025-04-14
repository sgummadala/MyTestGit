package com.cvs.pos;

public class MainClass {
	
	//static block 
	static  {
		System.out.println("print hello from static block ");
	}

	//Start of main method 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int result = execute();
		
		System.out.println("Result from execute method " + result);
		
		//calling non-static method requires object
		MainClassTest obj1 = new MainClassTest();
		obj1.method2();
		
		//static method call - no object required
		MainClassTest.method1();
		
		// print static variable no object reqd 
		System.out.println("print static variable " + MainClassTest.num1);
		   
		    // anonymous block 
			{
				System.out.println("print hello from anonymous block");
			}
		
	} // End of main method
	@SuppressWarnings("finally")
	public static 	int execute(){
			try{
				System.out.println("try block print");
				throw new RuntimeException();
			} catch (Exception e ){
				System.out.println("catch block print ");
				return 1;
			} finally {
				System.out.println("finally block print");
				return 3;
			}
		}
		

	}


