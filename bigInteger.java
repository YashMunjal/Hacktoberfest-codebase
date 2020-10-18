import java.util.*;
public class bigintergerstring{
    static String addup(String s1, String s2){
        String s3 = "";
        int s1_len, s2_len,bonus = 0;
        s1_len = s1.length() - 1;
        s2_len = s2.length() - 1;
        if(s1.length() >= s2.length())
        {
            int j = s2_len;
            for(int i = s1_len; i >= 0; i--){
                    // System.out.print(((int)s1.charAt(i)-'0'));
                    int res = 0;
                    if(j >= 0){
                        res = ((int)s1.charAt(i)-'0') + ((int)s2.charAt(j--)-'0');
                    }
                    else{
                        res = ((int)s1.charAt(i)-'0');
                    }
                    res += bonus;
                    if(res > 9){
                        bonus = res/10;
                    }
                    else{
                        bonus = 0;
                    }
                    s3 += res%10;
                    
                    if(i == 0 && bonus > 0)
                        s3+=bonus; 
                    
            }
        }
        else{
            int j = s1_len;
            for(int i = s2_len; i >= 0; i--){
                    // System.out.print(((int)s1.charAt(i)-'0'));
                    int res = 0;
                    if(j >= 0){
                        res = ((int)s2.charAt(i)-'0') + ((int)s1.charAt(j--)-'0');
                    }
                    else{
                        res = ((int)s2.charAt(i)-'0');
                    }
                   res += bonus;
                    if(res > 9){
                        bonus = res/10;
                    }
                    else{
                        bonus = 0;
                    }
                    s3 += res%10; 
                    
                    if(i == 0 && bonus > 0)
                        s3+=bonus; 
            }
        }
        return new StringBuilder(s3).reverse().toString();
    }
    static Boolean isSmaller(String str1, String str2) 
    { 
        // Calculate lengths of both string 
        int n1 = str1.length(), n2 = str2.length(); 
        if (n1 < n2) 
            return true; 
        if (n2 < n1) 
            return false; 
          
        for (int i = 0; i < n1; i++) 
        if (str1.charAt(i) < str2.charAt(i)) 
            return true; 
        else if (str1.charAt(i) > str2.charAt(i)) 
            return false; 
      
        return false; 
    } 
      
    static String findDiff(String str1, String str2) 
    { 
        if (isSmaller(str1, str2)) 
        { 
            String t = str1; 
            str1 = str2; 
            str2 = t; 
        } 
      
        String str = ""; 
      
        int n1 = str1.length(), n2 = str2.length(); 
        str1 = new StringBuilder(str1).reverse().toString(); 
        str2 = new StringBuilder(str2).reverse().toString(); 
          
        int carry = 0; 
      
        for (int i = 0; i < n2; i++) 
        { 
            int sub = ((int)(str1.charAt(i)-'0') -  (int)(str2.charAt(i)-'0')-carry); 
              
            if (sub < 0) 
            { 
                sub = sub + 10; 
                carry = 1; 
            } 
            else
                carry = 0; 
      
            str += (char)(sub + '0'); 
        } 
      
        for (int i = n2; i < n1; i++) 
        { 
            int sub = ((int)(str1.charAt(i) - '0') - carry); 
              
            if (sub < 0) 
            { 
                sub = sub + 10; 
                carry = 1; 
            } 
            else
                carry = 0; 
                  
            str += (char)(sub + '0'); 
        } 
      
        return new StringBuilder(str).reverse().toString(); 
    } 

    // static String findDiff(String s1, String s2){
    //     String s3 = "";
    //     int s1_len, s2_len,carry = 0;
    //     s1_len = s1.length() - 1;
    //     s2_len = s2.length() - 1;
    //     // System.out.println(s1_len + " " + s2_len);
    //     if(s1.length() >= s2.length())
    //     {
    //         int j = s2_len;
    //         for(int i = s1_len; i >= 0; i--){
    //                 int res = 0;
    //                 if(j >= 0){
    //                     if(((int)s1.charAt(i)-'0') > ((int)s2.charAt(j)-'0')){
    //                         res = ((int)s1.charAt(i)-'0') - ((int)s2.charAt(j--)-'0');
    //                         res -= carry;
    //                         carry = 0;
    //                         System.out.println("1"+res);
    //                     }
    //                     else if(((int)s1.charAt(i)-'0') == ((int)s2.charAt(j)-'0') && carry == 1){
    //                         int temp = (int)s1.charAt(i)-'0';
    //                         res = (10 + temp - 1) - ((int)s2.charAt(j--)-'0');
    //                         carry = 1;
    //                         System.out.println("2"+res);
    //                     }
    //                     else if(((int)s1.charAt(i)-'0') == ((int)s2.charAt(j)-'0')){
    //                         res = 0;
    //                         j--;
    //                         System.out.println("3"+res);
    //                     }
    //                     else{
    //                         int temp = (int)s1.charAt(i)-'0';
    //                         res = (10+temp) - ((int)s2.charAt(j--)-'0');
    //                         carry = 1;
    //                         System.out.println("4"+res);
    //                     }
                        
    //                 }
    //                 else{
    //                     res = ((int)s1.charAt(i)-'0');
    //                     res -= carry;
    //                     carry = 0;
    //                 }
    //                 s3+=res;
    //         }
    //         return new StringBuilder(s3).reverse().toString();
    //     }
    //     else{
    //         int j = s1_len;
    //         for(int i = s2_len; i >= 0; i--){
    //                 int res = 0;
    //                 if(j >= 0){
    //                     if(((int)s2.charAt(i)-'0') > ((int)s1.charAt(j)-'0')){
    //                         res = ((int)s2.charAt(i)-'0') - ((int)s1.charAt(j--)-'0');
    //                         res -= carry;
    //                         carry = 0;
    //                     }
    //                     else if(((int)s2.charAt(i)-'0') == ((int)s1.charAt(j)-'0') && carry == 1){
    //                         int temp = (int)s2.charAt(i)-'0';
    //                         res = (10+temp-1) - ((int)s1.charAt(j--)-'0');
    //                         carry = 1;
    //                     }
    //                     else if(((int)s2.charAt(i)-'0') == ((int)s1.charAt(j)-'0')){
    //                         res = 0;
    //                     }
    //                     else{
    //                         int temp = (int)s2.charAt(i)-'0';
    //                         res = (10+temp) - ((int)s1.charAt(j--)-'0');
    //                         carry = 1;
    //                     }
    //                 }
    //                 else{
    //                     res = ((int)s2.charAt(i)-'0');
    //                     res -= carry;
    //                     carry = 0;
    //                 }
    //                 s3+=res;
    //             }

    //         // s3+="-";
    //         }
    //         return new StringBuilder(s3).reverse().toString();
    //     }
  
    static String multiply(String num1, String num2) 
    { 
        int len1 = num1.length(); 
        int len2 = num2.length(); 
        if (len1 == 0 || len2 == 0) 
            return "0"; 
        
        int result[] = new int[len1 + len2]; 
        int i_n1 = 0;  
        int i_n2 = 0;  
        
        for (int i = len1 - 1; i >= 0; i--) 
        { 
            int carry = 0; 
            int n1 = num1.charAt(i) - '0'; 
        
            i_n2 = 0;  

            for (int j = len2 - 1; j >= 0; j--) 
            { 
                int n2 = num2.charAt(j) - '0'; 
                int sum = n1 * n2 + result[i_n1 + i_n2] + carry; 
                carry = sum / 10; 
                result[i_n1 + i_n2] = sum % 10; 
                i_n2++; 
            } 
        
            if (carry > 0) 
                result[i_n1 + i_n2] += carry; 
        
            i_n1++; 
        } 
    
        int i = result.length - 1; 
        while (i >= 0 && result[i] == 0) 
        i--; 
    
        if (i == -1) 
        return "0"; 
    
        String s = ""; 

        while (i >= 0) 
            s += (result[i--]); 
    
        return s; 
} 
public static String divide(String number, int divisor) 
{ 
    StringBuilder result = new StringBuilder(); 
    char[] d = number.toCharArray(); 

    int carry = 0; 
    for (int i = 0; i < d.length; i++) {
        int x = carry * 10 + ((int)d[i] - '0'); 
        // System.out.print((x / divisor));
        result.append(x / divisor); 
        // System.out.print((x % divisor));
        carry = x % divisor; 
    } 

    for (int i = 0; i < result.length(); i++) { 
        if (result.charAt(i) != '0') { 
            return result.substring(i); 
        } 
    } 
    return ""; 
} 
    

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Type the first no.");
        String s1 = sc.next();
        // System.out.print(s1.charAt(s1.length()) + " "+ s2.length());
        System.out.println("Press 1 for add and press 2 for subtract and press 3 for multiply and press 4 for divide");
        int t = sc.nextInt();
        System.out.println("Type the Second no.");
        if(t == 4){
            int divisor = sc.nextInt();
            System.out.print("Divided No. "+ divide(s1, divisor));
        }
        else if(t == 1){
            String s2 = sc.next();
            String s3 = addup(s1, s2);
            System.out.print("Added No. "+ s3);
        }
        else if(t == 2){
            String s2 = sc.next();
            String s3 = findDiff(s1, s2);
            System.out.print("Subtracted No. "+ s3);
        }
        else if(t == 3){
            String s2 = sc.next();
            System.out.print("Multiplied No. ");
            if ((s1.charAt(0) == '-' || s2.charAt(0) == '-') &&  (s1.charAt(0) != '-' || s2.charAt(0) != '-')) 
                System.out.print("-"); 
            
            if (s1.charAt(0) == '-' &&  s2.charAt(0) != '-')  
            { 
                s1 = s1.substring(1); 
            }  
            else if (s1.charAt(0) != '-' && s2.charAt(0) == '-') 
            { 
                s2 = s2.substring(1);
                // System.out.println("\nadf"+s2);
            }  
            else if (s1.charAt(0) == '-' &&  s2.charAt(0) == '-') 
            { 
                s1 = s1.substring(1); 
                s2 = s2.substring(1); 
            } 
            System.out.print(multiply(s1, s2));
        }
        System.out.println();
        sc.close();
    }
}
// Integer.parseInt("9");
// String s=String.valueOf(i);  
