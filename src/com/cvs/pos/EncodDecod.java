package com.cvs.pos;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import javax.xml.bind.DatatypeConverter; 

public class EncodDecod {

	public static void main(String[] args) throws IOException {  
		        // Getting encoder  
				Base64.Encoder encoder = Base64.getEncoder();  
				
			     // Getting decoder  
				Base64.Decoder decoder = Base64.getDecoder();
		      
 // /*			
  	            // Creating byte array  
		        byte[] byteArr = {1,2,3,4};  
		        // encoding byte array  
		        byte byteArr2[] = encoder.encode(byteArr);  
		        System.out.println("Encoded byte array: "+ byteArr2);  
		        
		        byte byteArr3[] = new byte[10];                // Make sure it has enough size to store copied bytes  
		        
		        int x = encoder.encode(byteArr,byteArr3);    // Returns number of bytes written  
		        
		        System.out.println("Encoded byte array written to another array: "+byteArr3);  
		        
		        System.out.println("Number of bytes written: "+x);  
// */	      
		        // Encoding string  
		        String str = encoder.encodeToString("Sriram Gummadala".getBytes());  
		        System.out.println("Encoded string: "+str);  
		        
		       
		        // Decoding string  
		        String dStr = new String(decoder.decode(str));  
		        System.out.println("Decoded string: "+dStr);  
		        
		        //Compress - GZIP
		        byte a[] = compress(str);
				String compressString = DatatypeConverter.printBase64Binary(a);
				System.out.println("Compressed String : "+ compressString );  
				
				
				//Uncompress - GZIP
				String decompressed = null;
				try {
					decompressed = decompress(DatatypeConverter
							.parseBase64Binary(compressString));

				} catch (IOException e) {
				}
				System.out.println("DeCompressed String : "+ decompressed );
		 
				//Decode - Uncompress
				// Decoding string  
		        String dStr1 = new String(decoder.decode(decompressed));  
		        System.out.println("Decoded string: "+dStr1); 
	
		        System.out.println("------------------------------------------"); 
		     
		        //String str = encoder.encodeToString("Sriram Gummadala".getBytes());  
		// below is what is happening java mapping in si008 for compression and decompression       
		        String str1 = "Sriram Gummadala" ;
		        byte b[] = compress(str1);
					String compressString_1 = DatatypeConverter.printBase64Binary(b);
					System.out.println("Compressed String : "+ compressString_1 );  
					System.out.println(Arrays.toString(b) );
	 

					//Uncompress - GZIP
				String decompressed_1 = null;
					try {
						decompressed_1 = decompress(DatatypeConverter
								.parseBase64Binary(compressString_1));

					} catch (IOException e) {
					}
					System.out.println("DeCompressed String : "+ decompressed_1 );
	
	
	}  
		
	
	public static byte[] compress(final String str) throws IOException {
		if ((str == null) || (str.length() == 0)) {
			return null;
		}
		ByteArrayOutputStream obj = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(obj);
		gzip.write(str.getBytes("UTF-8"));
		gzip.close();
		return obj.toByteArray();
		
		
	}
	
	public static String decompress(final byte[] compressed) throws IOException {
		String outStr = "";
		if ((compressed == null) || (compressed.length == 0)) {
			return "";
		}
		if (isCompressed(compressed)) {
			GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				outStr += line;
			}
		} else {
			outStr = new String(compressed);
		}
		return outStr;
	}

	public static boolean isCompressed(final byte[] compressed) {
		return (compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) ;
		
		}
		
	}



