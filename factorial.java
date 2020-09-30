class Main
{
    public static void main(String[] args)
    {
        // Write your code here
        Scanner in= new Scanner(System.in);
        int n=in.nextInt();
        int factorial=1;
        
        for(int i=1;i<=n;i++)
        {
          factorial=factorial*i;
        }
        System.out.print(factorial);
    }
    }