class Main
{
  public static void main(String[] args)
  {
    // Write your code here
    Scanner in = new Scanner (System.in);
    int sum=0;
    int arr[]=new int [10];
    for(int i=0;i<10;i++)
    {
      arr[i]=in.nextInt();
      sum=sum+arr[i];
    }
    System.out.print(sum);

    
  }
}