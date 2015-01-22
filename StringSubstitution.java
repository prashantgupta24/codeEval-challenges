package codeEval;

import java.util.*;
import java.io.*;

public class StringSubstitution {

	static ArrayList<String> inp = new ArrayList<String>();
	static int lastChValue = 0;
	
	public static void main(String[] args) {
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File("Stsub.txt")));
			
			String s;
			
			while((s=br.readLine())!=null)
			{
				inp.add(s);
			}
		}
		catch(Exception e)
		{
			//10011011001;0110,1001,1001,0,10,11
		}

		for (int i = 0; i < inp.size(); i++) {
			
			ArrayList<String> f = new ArrayList<String>();
			//ArrayList<String> r = new ArrayList<String>();
			HashMap<String, String> r = new HashMap<String, String>();
			
			String s = inp.get(i);
			String num = s.substring(0, s.indexOf(";"));
			String rNums = s.substring(s.indexOf(";")+1, s.length());
			String nums[] = rNums.split(",");
			
			for (int j = 0; j < nums.length; j++) {

				/*if (j % 2 == 0) {
					f.add(nums[j]);

				} else {
					r.add(nums[j]);
				}*/
				f.add(nums[j]);
				r.put(nums[j++], nums[j]);
			}
			
			StringBuilder ans = new StringBuilder();
			
			for (int j = 0; j < num.length(); j++) {
				
				char c = num.charAt(j);
				ans.append(c);
				ans = check(ans, f, r);
			}
			System.out.println(ans.toString());
		}
	}

	private static StringBuilder check(StringBuilder ans, ArrayList<String> f, HashMap<String, String> r) {
		
		String before = ans.substring(0, lastChValue);
		String after = ans.substring(lastChValue, ans.length());
		ans = new StringBuilder(after);
		
		String s = "";
		for (int i = 0; i < ans.length(); i++) {
			
			s = ans.substring(i,ans.length());
			
			if(f.contains(s))
			{
				ans.setLength(ans.length()-s.length());
				ans.append(r.get(s));
				lastChValue+=ans.length();
				break;
			}
		}

		if(before!="")
			return new StringBuilder(before+ans);
		else
			return ans;
	}

}
