package codeEval;

import java.io.*;
import java.util.*;

public class StringPermutations {
	
	static ArrayList<String> inp = new ArrayList<String>();
	static StringBuilder out;
	static boolean val[];
	static TreeSet<String> ts ;
	
	public static void main(String args[])
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File(args[0])));
			String s;
			
			while((s=br.readLine())!=null)
			{
				inp.add(s);
			}
		}
		catch(Exception e)
		{
			
		}
		
		
		for (int i = 0; i < inp.size(); i++) {

			String s = inp.get(i);
			val = new boolean[s.length()];
			out = new StringBuilder();
			ts = new TreeSet<String>();
			func(s);
			
			while(ts.size()>0) {
				
				if(ts.size()!=1)
					System.out.print(ts.pollFirst()+",");
				else
					System.out.print(ts.pollFirst());
			}
			System.out.println();
		}
	}

	private static void func(String s) {
		
		if(out.length() == s.length())
		{
			ts.add(out.toString());
			return;
		}
		
		for (int i = 0; i < s.length(); i++) {
			
			if(val[i])
				continue;
			
			out.append(s.charAt(i));
			val[i] = true;
			func(s);
			val[i] = false;
			out.setLength(out.length()-1);
		}
	}

}
