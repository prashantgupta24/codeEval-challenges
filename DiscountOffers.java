package codeEval;


import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class DiscountOffers {
	
	public static void main(String[] args) {
		
		ArrayList<String> ar = new ArrayList<String>();
		double mat[][] = new double[50][50];
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File(args[0])));

			String s;
			
			while((s=br.readLine())!=null)
			{
				ar.add(s);
			}
		
		}
		catch(Exception e)
		{
			
		}
		
		for (int i = 0; i < ar.size(); i++) {
			
			String s = ar.get(i);
			String nameString = s.substring(0,s.indexOf(';'));
			String prodString = s.substring(s.indexOf(';')+1, s.length());
			String names[] = nameString.split(",");
			String prods[] = prodString.split(",");
			
			for (int j = 0; j < prods.length; j++) {
				
				String prod = prods[j];
				
				for (int k = 0; k < names.length; k++) {

					double ss = 0;
					String cust = names[k];
					int prodLet = numLets(prod);
					int custLet = numLets(cust);
					int v = numVow(cust);

					if(prodLet%2==0)
					{
						ss = v*1.5;	
					}
					else
					{
						ss = custLet - v;
					}
					
					int gcd = getGCD(prodLet, custLet);
					
					if(gcd>1)
					{
						ss = ss*1.5;
					}
										
					mat[j][k] = ss;
				}
			}
			int max = Math.max(prods.length, names.length);
			
			double ans = getAns(mat, max , max);
			DecimalFormat df = new DecimalFormat("#.00"); 
			System.out.println(df.format(ans));
		}
		
	}

	private static double getAns(double[][] m, int i, int j) {

		TreeSet<Double> ts = new TreeSet<Double>(new comp());

		for (int k = 0; k < j; k++) {
			if (j == 1)
				return m[0][0];
			else {
				double ret = getAns(makeMat(m, i, j, k), i - 1, j - 1);
				ts.add(m[0][k] + ret);

			}
		}

		return ts.first();
	}
	
	  
	  private static double[][] makeMat(double m[][], int i, int j, int k)
	  {
		  int x = 0;
		  int y = 0;
		  double fmat[][] = new double[i-1][j-1];
		  
		  for(int a=1;a<i;a++)
		  {
			  for(int b=0;b<j;b++)
			  {
				  if(b!=k)
				  {
					  if(y==j-1)
					  {
						  x++;
						  y=0;
					  }
					  
					  fmat[x][y++] = m[a][b];
				  }
			  }
		  }
		  
		  return fmat;
	  }

	private static int numVow(String s) {

		int let = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			c = Character.toLowerCase(c);
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c =='y')
				let++;
		}
		
		return let;
	}

	private static int getGCD(int n1, int n2) {

		if(n1 == 0)
			return n2;
		if(n2 == 0)
			return n1;
		
		if(n1>n2)
			return getGCD(n2, n1%n2);
		else
			return getGCD(n1, n2%n1);
	}
	

	private static int numLets(String s)
	{
		int let = 0;
		for (int i = 0; i < s.length(); i++) {
			
			char c = s.charAt(i);
			if(Character.isLetter(c))
				let++;

		}
		
		return let;
	}
	
	private static class comp implements Comparator<Double>
	{
		public int compare(Double n1, Double n2)
		{
			if(n1<n2)
				return 1;
			else
				return -1;
		}
	}

}
