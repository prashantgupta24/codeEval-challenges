package codeEval;


import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class DiscountOffersITER {
	
	static ArrayList<TreeSet<Double>> row = new ArrayList<TreeSet<Double>>();
	
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
				TreeSet<Double> t = new TreeSet<Double>();
				
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
					t.add(ss);
					
				}
				
				row.add(t);
			}
			
			rowOp(mat,prods.length, names.length);
			columnOp(mat,prods.length, names.length);
			Konig(mat,prods.length, names.length);
		}
		
	}

	private static void Konig(double[][] mat, int iv, int jv) {
		
		findCover(mat, iv, jv);
		
	}

	private static void findCover(double[][] mat, int iv, int jv) {
		
		
		
	}

	private static void columnOp(double[][] mat, int iv, int jv) {

		ArrayList<TreeSet<Double>> col = new ArrayList<TreeSet<Double>>();
		
		for (int i = 0; i < iv; i++) {
			
			TreeSet<Double> t = new TreeSet<Double>();
			
			for (int j = 0; j < jv; j++) {
				t.add(mat[j][i]);
			}
			col.add(t);
		}
		

		for (int i = 0; i < iv; i++) {
			
			double val =  col.get(i).pollFirst();
					
			for (int j = 0; j < jv; j++) {
				
				mat[j][i] = mat[j][i]- val;
			}
		}
	}

	private static void rowOp(double[][] mat, int iv, int jv) {
		
		for (int i = 0; i < iv; i++) {
			
			double val =  row.get(i).pollFirst();
					
			for (int j = 0; j < jv; j++) {
				
				mat[i][j] = mat[i][j]- val;
			}
		}
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
