package codeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.TreeSet;

public class FindMin {
	
	static ArrayList<String> inp = new ArrayList<String>();
	
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

		for (int i = 0; i < inp.size(); i++) {
			
			int n,k,a,b,c,r;
			TreeSet<Integer> ts = new TreeSet<Integer>();
			ArrayList<Integer> ar = new ArrayList<Integer>();
			
			String s = inp.get(i);
			String sp[] = s.split(",");
			
			n = Integer.parseInt(sp[0]);
			k = Integer.parseInt(sp[1]);
			a = Integer.parseInt(sp[2]);
			b = Integer.parseInt(sp[3]);
			c = Integer.parseInt(sp[4]);
			r = Integer.parseInt(sp[5]);
			
			int m[] = new int[n];
			
			m[0] = a;
			ar.add(a);
			
			for (int j = 1; j < k; j++) {
				m[j] = (b * m[j - 1] + c) % r;
				ar.add(m[j]);
			}
			
			int no = 0;
			for (int j = k; j < n; j++) {
				
				ts = new TreeSet<Integer>(ar);
				no = 0;
				while(ts.size()>0 && ts.first() == no)
				{
					ts.pollFirst();
					no++;
				}
				
				m[j] = no;
				no++;
				ar.remove(0);
				ar.add(m[j]);
			}
			
			System.out.println(m[n-1]);
			
		}
	}

}
