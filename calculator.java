import java.util.*; 
import java.lang.*;
import java.io.*;

class Calculator {

int precedence(char op){ 
    if(op == '+'||op == '-') 
        return 1; 
    if(op == '*'||op == '/') 
        return 2; 
    return 0; 
}    
  
int op(int a, int b, char op){ 
    switch(op){ 
        case '+': return a+b; 
        case '-': return a-b; 
        case '*': return a*b; 
        case '/': return a/b; 
    }
    return -1;
} 
  
int evaluate(String s){ 
    Stack<Float> values = new Stack<Float>(); 
    Stack <Character> ops = new Stack<Character>(); 
      
    for(int i = 0; i < s.length(); i++){ 
          
         if(s.charAt(i) == '('){ 
            ops.push(s.charAt(i)); 
        } 
          
        else if(Character.isDigit(s.charAt(i))){ 
            int val = 0; 
              
            while(i < s.length() && Character.isDigit(s.charAt(i))) 
            { 
                val = (val*10) + (s.charAt(i)-'0'); 
                i++; 
                // System.out.println(val);
            } 
            i--;
            values.push(val);
            // values.push(s.charAt(i)-'0');
            
        } 

        else if(s.charAt(i) == ')') 
        { 
            while(!ops.empty() && ops.peek() != '(') 
            { 
                int val2 = values.pop(); 
                  
                int val1 = values.pop(); 
                  
                char op = ops.pop(); 
                  
                values.push(op(val1, val2, op)); 
            } 
            if(!ops.empty()) 
               ops.pop(); 
        } 
          
        else
        { 
            while(!ops.empty() && precedence(ops.peek()) >= precedence(s.charAt(i))){ 
                int val2 = values.pop(); 
                
                int val1 = values.pop(); 
                  
                char op = ops.pop(); 
                  
                values.push(op(val1, val2, op)); 
            } 
              
            ops.push(s.charAt(i)); 
        }
        // Enumeration enu = values.elements(); 
        // while (enu.hasMoreElements()) { 
        //     System.out.println(enu.nextElement()); 
        // }
        //  System.out.println();
        
    } 
       
        
    while(!ops.empty()){ 
        int val2 = values.pop();           
        
        int val1 = values.pop(); 
                  
        char op = ops.pop(); 
                  
        values.push(op(val1, val2, op)); 
    } 
      
    return values.pop(); 
    }
}
public class MyClass{
    public static void main(String args[]) {
        Calculator c = new Calculator();
        Scanner sc = new Scanner(System.in);
        String s = new String();
        s = sc.nextLine();
        System.out.print(c.evaluate(s));
    }
}
