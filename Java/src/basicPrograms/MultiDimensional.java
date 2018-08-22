package basicPrograms;

public class MultiDimensional {

	public static void main(String[] args) {

		String a[][]=new String[2][2];
		
		a[0][0]="ram";
		a[0][1]="raheem";
		
		a[1][0]="hello";
		a[1][1]="hi";
		
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length;j++)
			{
				System.out.print(a[i][j]+" ");
			}
		}
				System.out.println();
	}

}
