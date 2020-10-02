//BubbleSort

import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner obj = new Scanner(System.in);
		int n=obj.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
		    arr[i]=obj.nextInt();
		}
		for(int i=0;i<n-1;i++)
		{
		    for(int j=0;j<n-1;j++)
		    {
		        if(arr[j]>arr[j+1])
		        {
		            int temp=arr[j];
		            arr[j]=arr[j+1];
		            arr[j+1]=temp;
		        }
		    }
		}
		for(int i=0;i<n;i++)
		{
		    System.out.print(arr[i]+" ");
		}
	}
}