//-------------------------- For all Integers-----------------------//

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
		int a[]=new int[n];
		int a_a[]=new int[n];


        for(int i=0;i<n;i++) a[i]=sc.nextInt();

        // Taking variable to find min and max
        int max=a[0];
        int min=a[0];


        // Find max and min both to use this with negative integer too
        for(int i=0;i<n;i++) if(min>a[i]) min=a[i];
        for(int i=0;i<n;i++) if(max<a[i]) max=a[i];
        // Making new array ,which has size (max-min+1)
        int c[]=new int[max-min+1];
        
        // Counting occurence of a number in array
        for(int i=0;i<n;i++) ++c[a[i]-min];
        // Sum of all the count
        for(int i=1;i<max-min+1;i++) c[i]=c[i]+c[i-1];
        // Putting the value of i variable of array in its correct position then reducing the count too
        for(int i=0;i<n;i++)  a_a[--c[a[i]-min]]=a[i];
        // Print of sorted array
        for(int i=0;i<n;i++)  System.out.print(a_a[i]+" ");
        
        
        
	}
}
