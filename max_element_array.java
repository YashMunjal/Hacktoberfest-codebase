class Main
{
  public static void main(String[] args)
  {
    // Write your code here
    Scanner in=new Scanner(System.in);
    int arr[]= new int [5];
    int max=0;
    for(int i=0;i<5;i++)
    {
      arr[i]=in.nextInt();
    }
    
    for(int i=0;i<5;i++)
    {
      if(arr[i]>max)
      {
        max=arr[i];
      }
    }
    System.out.print(max);
    
    
    
  }
}