
class TestClass {
    public static void main(String args[] ) throws Exception {
        

        // Write your code here
     Scanner in = new Scanner (System.in);
      int n=in.nextInt();
      int arr[]=new int[n];
      for(int i=0;i<n;i++)
      {
          arr[i]=in.nextInt();          
      }
      int a[]=new int[n];
       a[0]=arr[n-1];
      int max=arr[n-1];
      int j=1;
      for(int i=n-2;i>=0;i--)
      {
         
          if(arr[i]>=max)
          {
            max=arr[i];
            a[j]=max;
            j++;
          }
      }
      for(int i=j-1;i>=0;i--)
      {
        System.out.print(a[i]+" ");
      }
    }
}