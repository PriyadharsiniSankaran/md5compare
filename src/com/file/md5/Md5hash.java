package com.file.md5;

import java.io.FileInputStream;
import java.security.MessageDigest;

public class Md5hash {

	 public String prefile(String file)
	    {
			try {
		    MessageDigest md = MessageDigest.getInstance("MD5");
			FileInputStream prelog = new FileInputStream(file);
		    byte[] data = new byte[1024];
		    int n = 0;
		    while ((n = prelog.read(data)) != -1) 
		    {
		        md.update(data, 0, n);
		        
		    };
		    byte[] mdbytes = md.digest();
		    StringBuffer sb = new StringBuffer();
		    for (int i = 0; i < mdbytes.length; i++) {
		        sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));       
		    }
		   System.out.println("MD5 Hash :: "+sb.toString());
			  
		    prelog.close();
		    return sb.toString();
		    
			}
			catch(Exception e)
			{
			System.out.println("Error");	
			
			}
			  return "";
	    }
}
