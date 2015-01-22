package codeEval;


import java.util.*;
import java.io.*;

public class StringSubstitution {

	static ArrayList<String> inp = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File(args[0])));
			
			String s;
			
			while((s=br.readLine())!=null)
			{
				s = s.trim();
				inp.add(s);
			}
		}
		catch(Exception e)
		{
		
		}

		for (int i = 0; i < inp.size(); i++) {
			
			ArrayList<String> f = new ArrayList<String>();
			HashMap<String, String> r = new HashMap<String, String>();
			
			String s = inp.get(i);
			s = s.trim();
			System.out.println(s);
			String num = s.substring(0, s.indexOf(";"));
			num = num.trim();
			String rNums = s.substring(s.indexOf(";")+1, s.length());
			String nums[] = rNums.split(",");
			
			for (int j = 0; j < nums.length; j++) {
				
				f.add(nums[j].trim());
				r.put(nums[j++].trim(), nums[j].trim());
			}
			
			for (int j = 0; j < f.size(); j++) {
				
				String st = f.get(j);
				String re = r.get(st);
				re = dis(re);
				num = num.replace(st, re);
			}
			
			num = reDis(num);
			System.out.println(num);
		}
	}

	private static String reDis(String num) {
		
		StringBuilder st = new StringBuilder();
		
		for (int i = 0; i < num.length(); i++) {
			 
			char c= num.charAt(i);
			if(c!='*')
				st.append(c);
		}
		
		return st.toString();
	}

	private static String dis(String re) {
		
		StringBuilder st = new StringBuilder();
		st.append('*');
		
		for (int i = 0; i < re.length(); i++) {
			st.append(re.charAt(i));
			st.append('*');
		}
		
		return st.toString();
	}

}
