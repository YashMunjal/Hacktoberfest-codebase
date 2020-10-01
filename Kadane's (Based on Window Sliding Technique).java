import java.util.Scanner;

/*
* 
*	To find maximum sum of subarray
*	Complexity: O(n)
*
*/


class Kadane{

	public static void main(String args[])
	{	
		Scanner sc=new Scanner(System.in);

		int n =sc.nextInt();
		int a[]=new int[n];

		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}

		System.out.println(kadane(a));
	}

		// Function to find maximum sum of subarray
		 static int kadane(int a[]){
			int max_after=Integer.MIN_VALUE,max=0;
			
			for(int i=0;i<a.length;i++)
			{max+=a[i];
						if(max_after<max) max_after=max;
						if(max<0) max=0;}
						return max_after;
		}

	}
