package com.file.filter;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Filterfile 
{
    public static String prefile(String input){
        try {
        	 
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
 
            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());
 
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
 
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            System.out.println(hashtext);
            return hashtext;
        }
            catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
 
    
    public String removespace(String file1)
    {
    	try {
    		String beforetrim=new String(Files.readAllBytes(Paths.get(file1)),"UTF-8").toString();
    		System.out.println(beforetrim);
    	    String result = new String(Files.readAllBytes(Paths.get(file1)), "UTF-8").trim().replaceAll("Request_body:", "").replaceAll("[^a-zA-Z0-9]", "")
    			.replaceAll("x0A", "").replaceAll("x22", "");
/*    	    String[] strArray = null; 
    	    strArray=result.split(" ");
    	    for (int i = 0; i< strArray.length; i++){  
    	    	System.out.print(strArray[i]+" "); 
    	    	
    	    	} */
		System.out.println(result);
		return result;
    	}
		catch(Exception e)
		{
		System.out.println("Error");	
		
		}
		return "";
    }
/*		public String[] converttoarray(String value)
		{
    	    String[] strArray = null; 
    	    strArray=value.split(" ");
    	    for (int i = 0; i< strArray.length; i++){  
    	    	System.out.print(strArray[i]+" "); 
    	    	//return strArray[i];
    	    	} 
		
		*/
    
}

