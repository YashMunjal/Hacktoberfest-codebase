class quicksort{

	void quicksort(int arr[],int l,int r){
		if(l<r){
				int par=partition(arr,l,r);
				quicksort(arr,l,par-1);
				quicksort(arr,par,r);}
	}
	int partition(int arr[],int l,int r){
	 
    int pivot = arr[r];  
    int i = l - 1;  
  
    for (int j = l; j < r ; j++)  
    {  
        
       if (arr[j] < pivot) 
            { 
                i++; 
  
           
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        
        int temp = arr[i+1]; 
        arr[i+1] = arr[r]; 
        arr[r] = temp; 
  
        return i+1; 
}  

	
	

    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    }  
	public static void main(String args[]) 
    { 
        int arr[] = {12, 11, 13, 5, 6, 7}; 
  
        System.out.println("Given Array"); 
        printArray(arr); 
  
        quicksort ob = new quicksort(); 
        ob.quicksort(arr, 0, arr.length-1); 
  
        System.out.println("\nSorted array"); 
        printArray(arr); 
    } 
} 
