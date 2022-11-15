package com.file.md5;

import java.io.IOException;

public class Comparefiles 
{
	private final static String prefile= "config/pre1.log";
	private final static String postfile= "config/post1.log";
	public static void main(String args[]) throws IOException 
	{	
		Md5hash md=new Md5hash();	
		String prehash=md.prefile(prefile);
		String posthash=md.prefile(postfile);

		if(prehash.equals(posthash))
				{
			System.out.println("MD5 match\n");	
				}
		else
		{
			System.out.println("MD5 mismatch\n");
			Difference.diff(prefile, postfile);
		}
		
	}
}
