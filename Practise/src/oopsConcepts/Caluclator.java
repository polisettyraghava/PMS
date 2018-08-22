package oopsConcepts;

public class Caluclator {

	int x=90;
	int y=100;
	public static void main(String[] args) {
		
		 Caluclator cal= new Caluclator();
		 cal.sum();
		 System.out.println("the y variable is:"+cal.x);
		 System.out.println("the x variable is:"+cal.y);
	}

public void sum()
{
	int a=90;
	int b=100;
	int c=a+b;
	System.out.println("the sum of 2 numbers is:"+c);
}


}

