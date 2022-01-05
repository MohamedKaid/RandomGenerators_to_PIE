//********************************************************************
//  GCD.java       Author: Kaid/Thabet
//
//  A class to generate the GCD and return it to main
//********************************************************************
public class GCD {
	
	private int one;
	private int two;
	
	public GCD() {}
	
	public GCD(int o, int t) {
		this.one=o;
		this.two=t;
	}

	public void setOne(int o) {one=o;}
	public void setTwo(int t) {two=t;}
	
	public int getOne() {return one;}
	public int getTwo() {return two;}
	
	public int getGCD() {
		 int r=0,d=0;
		if (one<two) {
			int temp=one;
			one=two;
			two=temp;
			while(true){
				r=one%two;
				if(r==0) {
					break;
				}
				one=two;
				two=r;
				if(two==1)
					break;
					
			}
			return two;
		}else 
			while(true){
				r=one%two;
				if(r==0) {
					break;
				}
				one=two;
				two=r;
				if(two==1)
					break;	
			}
				return two;
}
	public String toString() {
		String value=getOne()+","+getTwo();
		return value;
	}
}


