//********************************************************************
//  Main.java       Author: Kaid/Thabet
//
//  Represents a Main program to run the program
//********************************************************************
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		double piAvg = 0.0;
		int avg=0;
		int x,y;
		GCD rng = new GCD();
		String pi="Pi_Values.txt";
		ArrayList<Integer>prng = new ArrayList<Integer>();
		ArrayList<Integer>csprng=new ArrayList<Integer>();
		ArrayList<Integer>trng=new ArrayList<Integer>();


		File input = new File(pi);
		try (
				PrintWriter est_PI = new PrintWriter(input);
				){ 
			est_PI.println();
			est_PI.println("****Statistical Estimate of Pi using Cesaro's Theorem****");
			est_PI.println("PRNG:");
			for(int i=0;i<30;i++) //for loop to run the estimate 30 times
			{
				for(int i1=1;i1<101;i1++) //for loop to generate 100 pair of integers
				{
					prng.remove(prng);
					Random r = new Random();
					x=r.nextInt(100)+1;
					rng.setOne(x);
					y=r.nextInt(100)+1;
					rng.setTwo(y);
					rng = new GCD(rng.getOne(),rng.getTwo());
					if(rng.getGCD()==1)//if GCD value is 1 
					{
						prng.add(x);
						prng.add(y);
						avg++;
					}
				}
				piAvg+=getPi(avg/100.0);//gets the pi average
				avg=0;
			}
			piAvg/=30.0;
			System.out.println("PRNG finished:\t"+piAvg);
			est_PI.println("The PI average for a PRNG is:\t"+piAvg);//writes the estimate of pi to the .text file
			//--------------------------new generator-----------------------------

			piAvg=0;
			avg=0;
			est_PI.println();
			est_PI.println("CSPRNG:");
			SecureRandom rand= new SecureRandom();

			for(int i=0;i<30;i++) //for loop to run the estimate 30 times
			{
			for(int i1=1;i1<101;i1++) //for loop to generate 100 pair of integers
				{
				x=rand.nextInt(100)+1;
				rng.setOne(x);
				y=rand.nextInt(100)+1;
				rng.setTwo(y);
				rng = new GCD(rng.getOne(),rng.getTwo());
				if(rng.getGCD()==1) {
					csprng.add(x);
					csprng.add(y);
					avg++;
				}
			}
			piAvg+=getPi(avg/100.0);//finds the average of pi for the generated numbers
			avg=0;
			}
			piAvg/=30.0;
			System.out.println("CSPRNG finished:"+piAvg);
			est_PI.println("The PI average for a CSPRNG is:\t"+piAvg);//writes the estimate of pi to the .text file
			

			//--------------------------new generator-----------------------------

			piAvg=0;
			avg=0;
			est_PI.println();
			est_PI.println("TRNG:");
			for(int i=0;i<30;i++) //for loop to run the estimate 30 times
			{
			String address = "https://www.random.org/integers/?"
					+ "num=200&min=1&max=100&col=2&base=10&format=plain&rnd=new";//loop to generate 100 pair of integers
			try {
				URL u = new URL(address);
				HttpURLConnection connection = (HttpURLConnection)u.openConnection();
				InputStream stream = connection.getInputStream();
				Scanner in = new Scanner(stream);
				
				while (in.hasNext()) {
					x=Integer.parseInt(in.next());
					y=Integer.parseInt(in.next());
					rng.setOne(x);
					rng.setTwo(y);
					if(rng.getGCD()==1)
					{
						trng.add(x);
						trng.add(y);
						avg++;
					}
				} 
				piAvg+=getPi(avg/100.0);//finds the average of pi for the generated numbers
				avg=0;
				}	
			catch (java.net.MalformedURLException ex) {
				System.out.println("Invalid URL");
			}
			catch (java.io.IOException ex) {
				System.out.println("IO Errors");
			}
		}
			piAvg/=30.0;
			System.out.println("TRNG finished:\t"+piAvg);
			est_PI.println("The PI average for a TRNG is:\t"+piAvg);//writes the estimate of pi to the .text file
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//Method that uses Cesaro's Theorem
	public static double getPi(double avg) {
		return Math.sqrt(6.0/avg);
	}

}
