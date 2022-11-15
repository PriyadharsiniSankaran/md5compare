package com.file.filter;

import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Comparehash 
{
	private final static String prefile= "config/Prefile.log";
	private final static String postfile= "config/Postfile.log";
	//private final static String extract= "config/extract";
	public static void main(String args[]) throws FileNotFoundException, NoSuchAlgorithmException
	{	
		backup md=new backup();
		String prehash=md.prefile(prefile);
		String posthash=md.prefile(postfile);
		System.out.println(prehash.equals(posthash));		
	}

}
