package com.file.filter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class backup {
	public static Map<String, String> finderror(String file)
    {
		   HashMap<String, String> map = new HashMap<>();
		   String line;
		   try(BufferedReader br = new BufferedReader(new FileReader(file)))
{
    while ((line = br.readLine()) != null)
    {
    	String[] keyValuePair = line.split(":",2);
        if (keyValuePair.length > 1) 
        {
            String key = keyValuePair[0];
            String value = keyValuePair[1];
            //System.out.println(key,value);
            map.put(key, value);
        }
        else {
            System.out.println("No Key:Value found in line, ignoring: " + line);
        }
        
    } 
    }
        catch (IOException e) 
		   {
            e.printStackTrace();
		   }   
    return map;
		   }
    
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
		    System.out.println("File Hash :: "+sb.toString());
			  
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
