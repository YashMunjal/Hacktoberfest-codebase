import java.util.Scanner;
public class Main{
    public static void main(String args[]){
        String words[]={"", "one", "two", "three", "four", "five", "six","seven", "eight", "nine","ten",
        "eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen",
        "twenty","twenty one", "twenty two", "twenty three", "twenty four", "twenty five",
        "twenty six","twenty seven","twenty eight", "twenty nine"};
        Scanner sc=new Scanner(System.in);
        int h=sc.nextInt();
        int m=sc.nextInt();
        String min="";
        if(m==1||m==59)
        min="minute";
        else
        min="minutes";
        if(m==0){
            System.out.println(words[h]+" o' clock");
        }
        else if(m==15){
            System.out.println("quarter past "+words[h]);
        }
        else if(m==30){
            System.out.println("half past "+words[h]);
        }
        else if(m==45){
            System.out.println("quarter to "+words[h+1]);
        }
        else if(m<30){
            System.out.println(words[m]+" "+min+" past "+words[h]);
        }
        else if(m>30){
            if(h==12)
            System.out.println(words[60-m]+" "+min+" to "+words[h+1-12]);
            else
            System.out.println(words[60-m]+" "+min+" to "+words[h+1]);
        }
        else{
            System.out.println("Invalid Input !");
        }
    }
}
