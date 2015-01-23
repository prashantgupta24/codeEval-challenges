package codeEval;

import java.util.*;
import java.io.*;

public class KnightMoves {

	static ArrayList<String> inp = new ArrayList<String>();
	static TreeSet<String> ts;
	static HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	static HashMap<Integer, String> revMap = new HashMap<Integer, String>();
	
	
	public static void main(String[] args) {

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
		
		map.put('a', 1);
		map.put('b', 2);
		map.put('c', 3);
		map.put('d', 4);
		map.put('e', 5);
		map.put('f', 6);
		map.put('g', 7);
		map.put('h', 8);
		
		revMap.put(1, "a");
		revMap.put(2, "b");
		revMap.put(3, "c");
		revMap.put(4, "d");
		revMap.put(5, "e");
		revMap.put(6, "f");
		revMap.put(7, "g");
		revMap.put(8, "h");
		
		for (int i = 0; i < inp.size(); i++) {
			
			String s = inp.get(i);
			ts = new TreeSet<String>();
			 
			int x = map.get(s.charAt(0));
			int y = Character.getNumericValue(s.charAt(1));

			if (x - 2 > 0) {
				if (y - 1 > 0)
					ts.add(revMap.get(x-2)+(y-1));
				if (y + 1 < 9)
					ts.add(revMap.get(x-2)+(y+1));
			}

			if (x + 2 < 9) {
				if (y - 1 > 0)
					ts.add(revMap.get(x+2)+(y-1));
				if (y + 1 < 9)
					ts.add(revMap.get(x+2)+(y+1));
			}
			if (y + 2 < 9) {
				if (x - 1 > 0)
					ts.add(revMap.get(x-1)+(y+2));
				if (x + 1 < 9)
					ts.add(revMap.get(x+1)+(y+2));
			}
			if (y - 2 > 0) {
				if (x - 1 > 0)
					ts.add(revMap.get(x-1)+(y-2));
				if (x + 1 < 9)
					ts.add(revMap.get(x+1)+(y-2));
			}
			
			while(ts.size()>0) {
				System.out.print(ts.pollFirst()+" ");
			}
			
			System.out.println();
		}
		


	}

}








  