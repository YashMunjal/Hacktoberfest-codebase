import java.io.*; 
import java.util.*; 
  
class Radix { 
  
    
    static int max(int arr[], int n) 
    { 
        int m = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] > m) 
                m = arr[i]; 
        return m; 
    } 
  
    static void count(int arr[], int n, int exp) 
    { 
        int arr_o[] = new int[n];
        int i; 
        int c[] = new int[10]; 
    
  
        
        for (i = 0; i < n; i++) 
            c[ (arr[i]/exp)%10 ]++; 
  
        
        for (i = 1; i < 10; i++) 
            c[i] += c[i - 1]; 
  
        
        for (i = n - 1; i >= 0; i--) 
        { 
            arr_o[--c[ (arr[i]/exp)%10 ]] = arr[i]; 
            
        } 
  
       
        for (i = 0; i < n; i++) 
            arr[i] = arr_o[i]; 
    } 
  
    static void sort(int arr[], int n) 
    { 
         
        int m = max(arr, n); 
  
       
        for (int exp = 1; m/exp > 0; exp *= 10) 
            {count(arr, n, exp);
                System.out.println("Again");
            for (int i=0; i<n; i++) System.out.print(arr[i]+" ");
                System.out.println();
            }

    } 
  

    public static void main (String[] args) 
    { 
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n]; 
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        sort(arr, n);
    System.out.println("After Sort");
        for (int i=0; i<n; i++)  System.out.print(arr[i]+" ");  
         
    } 
} 