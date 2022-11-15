package com.file.md5;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;
public class Difference {
	public static void diff(String prefile,String postfile) throws IOException
	{	
		FileInputStream prefilestream = new FileInputStream(prefile);
		FileInputStream postfilestream = new FileInputStream(postfile);
		BufferedReader reader1 = new BufferedReader(new InputStreamReader(prefilestream));
		BufferedReader reader2 = new BufferedReader(new InputStreamReader(postfilestream));
		String file1_line = null,file2_line = null;	
		int line_count=0;
		long file1_count=count(prefile);
		long file2_count=count(postfile);
		if(file1_count>=file2_count)
		{
		
		call(reader1,file1_line,file2_line,line_count,postfile);
		}
		else 
		{
		call(reader2,file1_line,file2_line,line_count,prefile);	
		}
		//Close the input stream
		prefilestream.close();
		postfilestream.close();
	}
	public static void call(BufferedReader reader,String file1_line,String file2_line,int line_count2,String file) throws IOException
	{
		while ((file1_line = reader.readLine()) != null)
		{		
			file2_line=readfile2(line_count2,file);			
			if(file2_line.length() > 0 & !file1_line.equals(file2_line))
			{	
				line_count2++;
				System.out.println("Mismatch in Line number "+line_count2 +" ");
				finddifference(file1_line,file2_line);
				System.out.println();		
				
		}		
			else if(file1_line.equals(file2_line))
			{
				line_count2++;
				System.out.println("Line "+line_count2+" Match\n");
				
			}
			else
			{
				line_count2++;
				System.out.println("Line "+line_count2+" is not available in "+file);
			}
		}
	}


public static String readfile2(int n,String file) throws NoSuchElementException
{ 
String line ="";
try (Stream<String> stream = Files.lines(Paths.get(file))) 
{
	Optional<String> temp = stream.skip(n).findFirst();
	if(!temp.isEmpty()) {
		line= temp.get();
		return line;
	}
	return line;
	  
}
catch(IOException e)
{
  System.out.println(e);
}

return line;
}
	  public static void finddifference(String file1_line,String file2_line)
	  {
			String[] value1=file1_line.split(",");
			String[] value2=file2_line.split(",");
			ArrayList<String> List1 = new ArrayList<String>(Arrays.asList(value1));
			ArrayList<String> List2 = new ArrayList<String>(Arrays.asList(value2));
			//System.out.println("Common elements: " +List1.stream().filter(List2::contains).collect(Collectors.toList()));   
			List1.removeAll(List2);
			System.out.println("Changes "+List1);

	  }
	  public static long count(String fileName) {

	      Path path = Paths.get(fileName);

	      long lines = 0;
	      try {
	          lines = Files.lines(path).count();

	      } catch (IOException e) {
	          e.printStackTrace();
	      }
	      return lines;

	  }
}
