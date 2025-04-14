package com.cvs.pos;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadPipeDelimited {

	public static void main(String[] args) throws FileNotFoundException {
		
		String hFields[] = new String[20]; 
		
		//ArrayList<String> headerList = new ArrayList<>();
		List<String> headerList = new ArrayList<>();
        headerList.add("STORE");
        headerList.add("TXN_DATE");
        headerList.add("REGISTER");
        headerList.add("TRAN_NBR");
        headerList.add("REC-TYPE");
        headerList.add("LINE_SEQ");
        headerList.add("TRAN-TYPE");
        headerList.add("TOTAL-AMT");
        headerList.add("BALANCE-DUE");
        headerList.add("XTRA-CARE-CARD-NBR");
        headerList.add("CASHIER-ID");
        headerList.add("EMP-TXN-IND");
        headerList.add("EXT-ORDER-NUMBER");
        headerList.add("INT-ORDER-NUMBER");
        headerList.add("ORDER-DATE");
        headerList.add("INVOICE-NUMBER");
        headerList.add("PROGRAM-NAME");
        headerList.add("CUST-CITY");
        headerList.add("CUST-STATE");
        headerList.add("CUST-ZIPCODE");
      
        ArrayList<String> ItemList = new ArrayList<>();
        ItemList.add("STORE");
        ItemList.add("TRAN-DATETIME");
        ItemList.add("REGISTER");
        ItemList.add("TRAN-NBR (SHIPBINID)");
        ItemList.add("REC_TYPE");
        ItemList.add("Line Seq#");
        ItemList.add("ITM-TYPE");
        ItemList.add("SKU-NBR  (CVS ID)");
        ItemList.add("UPC-NBR  ( REG UPC)");
        ItemList.add("DEPT-NBR");
        ItemList.add("QUANTITY");
        ItemList.add("SELL-PRICE");
        ItemList.add("EXTND-SELL-PRICE-AMT");
        ItemList.add("LIST -PRICE");
        ItemList.add("ITEM-COST-AMT");
        ItemList.add("LINE_GROSS_AMT");
        ItemList.add("FSA-INDICATOR");
        
        /*
        ItemList.add("TAXABLE-IND");
        ItemList.add("UPC ( SF - UPC)");
        ItemList.add("PRODUCT_DESCRIPTION");
        ItemList.add("PRODUCT_CATEGORY");
        ItemList.add("VENDOR_NAME");
		*/
        
        
        ArrayList<String> TaxList = new ArrayList<>();
        TaxList.add("STORE");
        TaxList.add("TRAN-DATETIME");
        TaxList.add("REGISTER");
        TaxList.add("TRAN-NBR");
        TaxList.add("REC_TYPE");
        TaxList.add("Line Seq#");
        TaxList.add("TAX-TYPE");
        TaxList.add("TOTAL-TAX");
        TaxList.add("TAXABLE-AMT");

        
        ArrayList<String> TenderList = new ArrayList<>();
        TenderList.add("STORE") ;
        TenderList.add("TRAN-DATETIME");
        TenderList.add("REGISTER");
        TenderList.add("TRAN-NBR");
        TenderList.add("REC_TYPE");
        TenderList.add("Line Seq#");
        TenderList.add("TNDR-TYPE");
        TenderList.add("TNDR-AMT");
        TenderList.add("CARD-TYPE");
        TenderList.add("TNDR-ACCT-NBR");
        TenderList.add("EXPIRATION-DT");
        TenderList.add("AUTH-CODE");
        TenderList.add("APPROVAL-SRC");
        TenderList.add("TOKEN-ID");
        TenderList.add("AUTH-TRAN-ID");
        TenderList.add("EMV-FLAGS");
        TenderList.add("AUTH-TXN-ID");
        TenderList.add("CAPTURE-TXN-ID");
        TenderList.add("CAPTURE-ID");

        
        ArrayList<String> ItemExtList = new ArrayList<>();
        ItemExtList.add("STORE");
        ItemExtList.add("TRAN-DATETIME");
        ItemExtList.add("REGISTER");
        ItemExtList.add("TRAN-NBR");
        ItemExtList.add("REC_TYPE");
        ItemExtList.add("Line Seq#");
        ItemExtList.add("DISC-TYPE");
        ItemExtList.add("DISC_CPN-AMT");
        ItemExtList.add("PROMO_CD");
        ItemExtList.add("DISC-CARD-NBR");
        ItemExtList.add("CPN-TYPE");
        ItemExtList.add("CPN-SKU");
        ItemExtList.add("COUPON-ID");
        ItemExtList.add("CPN-SEQ");
        ItemExtList.add("CPN-CMPGN-ID");
        ItemExtList.add("CPN-CMPGN-SEQ");
        ItemExtList.add("CPN-MATCH-CD");

        
		//creating File instance to reference text file in Java
		String filePath = "C:/Java/Data/MyFileTlog.txt";
		File text = new File(filePath);
      
        //Creating Scanner instance to read File in Java
        Scanner scnr = new Scanner(text);
      
        //Reading each line of file using Scanner class
        // defining the String format
        String format = "%-20s%s%n";
        
        int lineNumber = 1;
        while(scnr.hasNextLine()){
            String line = scnr.nextLine();
            System.out.println("line " + lineNumber + " :" + line);
            lineNumber++;
        }
          //Reading each line of file and printing delimited fields
          
           try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String Pipedline;
                while ((Pipedline = br.readLine()) != null) {
                    String[] values = Pipedline.split("\\|");
                    //System.out.println(values[4]);
                   if (Integer.valueOf((values[4])) == 10) {
                	   System.out.println("==================================================");
                	   System.out.println("Header row fields count : "  + values.length);
                	   System.out.println("==================================================");
                	   for (int i = 0; i < headerList.size(); i++) {
                	      // System.out.println(headerList.get(i) + "\t\t\t" +":" + "\t\t\t" + values[i] );
                	      // System.out.println(headerList.get(i) + "\t\t\t" +":" + "\t\t\t" + values[i] );
                    	  //   System.out.printf("|%-10s|", headerList.get(i));
                	      //   System.out.printf("|%-10s|\n", values[i]);
                	      //  String format = "%-20s%s%n";
                		 System.out.printf(format, headerList.get(i)," : "+ values[i]);
                         
                       }
                   }
                   else if (Integer.valueOf(values[4]) == 11) {
                	   System.out.println("==================================================");
                	   System.out.println("Line Item row fields : "  + values.length );
                	   System.out.println("==================================================");
                 	   for (int i = 0; i < ItemList.size(); i++) {
                	   System.out.printf(format, ItemList.get(i)," : "+ values[i]);
                 	   }
                   }
                   else if (Integer.valueOf(values[4]) == 13) {
                	   System.out.println("==================================================");
                	   System.out.println("Tax  row fields : "  + values.length );
                	   System.out.println("==================================================");
                 	   for (int i = 0; i < TaxList.size(); i++) {
                	   System.out.printf(format, TaxList.get(i)," : "+ values[i]);
                 	   }
                   }
                   else if (Integer.valueOf(values[4]) == 14) {
                	   System.out.println("==================================================");
                	   System.out.println("Tender Item row fields : "  + values.length );
                	   System.out.println("==================================================");
                 	   for (int i = 0; i < TenderList.size(); i++) {
                	   System.out.printf(format, TenderList.get(i)," : "+ values[i]);
                 	   }
                   }
                   else if (Integer.valueOf(values[4]) == 21) {
                	   System.out.println("==================================================");
                	   System.out.println("ItemExtension row fields : "  + values.length );
                	   System.out.println("==================================================");
                 	   for (int i = 0; i < ItemExtList.size(); i++) {
                	   System.out.printf(format, ItemExtList.get(i)," : "+ values[i]);
                 	   }
                   }
                   else {
                	   System.out.println("Default");
                   }
                 //For each loop syntax
                 /*
                    for (String value : values) {
                        //System.out.print(value.trim() + "\t");
                        //System.out.println(value[0]);
                    }
                    System.out.println();
                 */
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            
          // for (int i = 0; i < stringArray.length; i++) {
          //      System.out.println("String at position " + i + " of the array: " + stringArray[i]);
          //  }  
          //   
          // System.out.println("Using a for loop:");
          // for (int i = 0; i < arrayList.size(); i++) {
          //     System.out.println(arrayList.get(i));
          // }
          // // Using printf to format output with spaces
          // System.out.printf("Name: %-10s Age: %3d Salary: %10.2f%n", name, age, salary);
          // System.out.printf("|%-10s|%-10s|%-10s|\n", "Column 1", "Column 2", "Column 3");
          //  System.out.printf("|%-10s|%-10s|%-10s|\n", "Value 1", "Value 2", "Value 3");

           //String format = "%-40s%s%n";
           //System.out.printf(format, prefix1, msg);
           //System.out.printf(format, prefix2, msg);
} //End of main
	
} //End of Class




