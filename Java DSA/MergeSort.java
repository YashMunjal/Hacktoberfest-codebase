/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;

class Sort
{
    int arr[];
    Scanner sc =new Scanner(System.in);
    
    public int scan()
    {
        System.out.print(" Enter the Size Of the Array: ");
        arr = new int[sc.nextInt()];
        System.out.print("\nEnter the elements of the Array:  ");
        for(int i=0;i<arr.length;arr[i++]=sc.nextInt());
        
        return arr.length;
    }
    public void merge(int arr[],int start,int mid,int end)
    {
        int arr1[] = new int[mid-start+1];
        int arr2[] = new int[end-mid];
        int i=0,j=0;
        for(i=0;i<arr1.length;i++)
        {
            arr1[i] = arr[start+i];
        }
        for(j=0;j<arr2.length;j++)
        {
            arr2[j] = arr[mid+1+j];
        }
        i=0;j=0;
        int k=start;
        while(i<arr1.length && j<arr2.length)
        {
            if(arr1[i]<=arr2[j])
            {
                arr[k++]=arr1[i++];
            }
            else
            {
                arr[k++]=arr2[j++];
            }
        }
        while(i<arr1.length)
        {
            arr[k++]=arr1[i++];
        }
        while(j<arr2.length)
        {
            arr[k++]=arr2[j++];
        }
    }
    public void mergeSort(int arr[],int start,int end)
    {
        if(start<end)
        {
            int mid=(start+end)/2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
    }
    public void QuickSort(int arr[],int start,int end)
    {
        if(start<end)
        {
            int pivot = arr[end];
            int i=0,j=0;
            
            for(j=0;j<end;j++)
            {
              if(arr[j]<pivot)
              {
                  int tmp=arr[i];
                  arr[i]=arr[j];
                  arr[j]=tmp;
                  i++;
              }
            }
            
            arr[end]=arr[i];
            arr[i]=pivot;
            
            QuickSort(arr,start,i-1);
            QuickSort(arr,i+1,end);
        }
        else
        {
            return;
        }
    }
}
public class Main
{
	public static void main(String[] args) {
		
		Sort sort = new Sort();
		sort.scan();
		sort.mergeSort(sort.arr,0,sort.arr.length-1);
		
		for(int i:sort.arr)
		{
		    System.out.print(i+" ");
		}
	}
}
