package com.cvs.pos;

import java.util.*;

public class VPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Integer[] arr = new Integer[] {1,2,3,4,5};
	ArrayList<Integer> al1 = new ArrayList<>();
	al1.add(500);
	
	
	Stack<String> st = new Stack<>() ;
	st.add("White");
	st.add("red");
	st.add("pink");
	System.out.println(st);
	
	
	LinkedList<String> ll = new LinkedList<>();
	ll.add("Y1");
	ll.add("Y2");
	System.out.println(ll);
	//for each loop
	for(String s :ll){
		System.out.println(s);
	}
	
	
	HashMap<Integer,  String > hmp = new HashMap<>();
	hmp.put(1,"Sriram-hm") ;
	
	System.out.println(hmp);
	
	
	
///*
	ArrayList<Integer> al2 = new ArrayList<>(Arrays.asList(arr));
	for (int i = 0; i<al2.size(); ++i) {
		System.out.println(al2.get(i));
	}
//*/
	Vector v2 = new Vector();
	ArrayList al = new ArrayList();
	
	Vector v1 = new Vector();
	v1.add("Raj") ;
	v1.add("Madhuri");
	v1.add(0, "tejas");
	v1.add("Raj1") ;

	
	System.out.println(v1);
	System.out.println(v1.size());
	System.out.println(v1.capacity());
	
	System.out.println(v2);
	v2.add("Second list") ;
	v2.addAll(0,v1);
	System.out.println(v2);
	
	System.out.println(al1);
	
	}

}
