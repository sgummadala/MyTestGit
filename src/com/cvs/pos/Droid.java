package com.cvs.pos;

public class Droid {
	  int batteryLevel = 0;
	  String name = null ;
	  
	  public static void main(String[] args){
	  Droid droidInst = new Droid("Codey");
	  System.out.println(droidInst);
	  System.out.println(droidInst.batteryLevel) ;
	  droidInst.performTask("dancing") ;
	  }

	  public Droid(String droidName){
	   batteryLevel = 100;
	   name = droidName ;
	  }

	  public String toString() {
	    return " Hello I'm the droid :" + name  ;
	  }

	  public void performTask(String task){
	  System.out.println(name + "is performing task : " + task );
	  }
	}