import java.util.Scanner;
class Power
{
   public static void main(String arg[])
	
   {
	
       long num, power, result = 1;
       Scanner sc = new Scanner( System.in );

       System.out.println("Enter number");
       num = sc.nextLong();
 
       System.out.println("Enter power");
       power = sc.nextLong();
 
       if(num >= 0 && power == 0)  
          result = 1;

       else if( num == 0 && power >= 1)
            result = 0;

       else 
            for( int i = 1; i <= power; i++)
                resulr=result *num;   
 
    	  System.out.println(num+"^"+power+" = "+result);
 
    }
 
}