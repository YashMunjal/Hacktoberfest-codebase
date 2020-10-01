import java.util.Scanner;
class Main
{
  public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    for(int k=0;k<t;k++){
      int n=sc.nextInt();
      int [][]a=new int [n][n];
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
          a[i][j]=sc.nextInt();
        }
      }
      int cycle,lb=0,rb=n-1,tb=0,bb=n-1;
      if(n%2==0)
        cycle=n/2-1;
      else
        cycle=n/2;
     for(int l=0;l<=cycle;l++){
       for(int i=lb;i<rb;i++){
        int temp=a[tb][i];
        a[tb][i]=a[bb-i+tb][lb];
        a[bb-i+tb][lb]=a[bb][rb-i+lb];
        a[bb][rb-i+lb]=a[i][rb];
        a[i][rb]=temp;
       }
       lb++;
       rb--;
       tb++;
       bb--;
     }
     for(int i=0;i<n;i++){
         for(int j=0;j<n;j++)
            {if(j==n-1)
              System.out.print(a[i][j]);
             else
           System.out.print(a[i][j]+" ");}
     System.out.println();}
     System.out.println();
    }
    
  }
}