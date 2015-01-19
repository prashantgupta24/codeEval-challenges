package codeEval;

import java.io.*;
import java.util.*;
import java.util.Map.*;

public class LongestLines {


	public static void main(String[] args) {
		
		int len = 0;
		/*HashMap<Integer, String> hm = new HashMap<Integer, String>();
		TreeSet<Integer> t = new TreeSet<Integer>(new comp());*/
		
		TreeMap<Integer, String> tm = new TreeMap<Integer, String>(new comp());
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File("a.txt")));

			String s;
			len = Integer.parseInt(br.readLine().trim());
			
			while((s=br.readLine())!=null)
			{
				s = s.trim();
				int l = s.length();
				tm.put(l,s);
			}
		}
		catch(Exception e)
		{
			
		}
		
		for (int i = 0; i < len; i++) {
			Entry<Integer, String> e = tm.pollFirstEntry();
			System.out.println(e.getValue());
		}

	}
	
	static class comp implements Comparator<Integer>
	{
		public int compare(Integer n1, Integer n2)
		{
			if(n1.compareTo(n2) < 0)
				return 1;
			else
				return -1;
		}
	}
		

}
