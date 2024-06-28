//Added Another Comment
import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      String s = "[()]{}{[()()]()}";
      boolean ans = checkThis(s);

      System.out.println("Brackets are satisfied : " + ans);
    }
    
    public static boolean checkThis(String s)
    {
        //Stack
        Stack<Character> myS = new Stack<Character>();
        //Flag to handle corner cases, like all closing brackets or after all push/pop finally extra closing bracket etc.
        boolean flag = false;
        for(int i = 0; i < s.length(); ++i)
        {
            //If Starting brackets -  Push it in stack and make flag as true since at least one element is pushed.
            if(s.charAt(i)=='{' || s.charAt(i)=='(' || s.charAt(i)=='[')
            {
                myS.push(s.charAt(i));
                flag = true;
            }
            
            //If Closing bracket is found but stack is empty, flag to false.
            if(s.charAt(i)==']' && myS.empty() || s.charAt(i)=='}' && myS.empty() || s.charAt(i)==')' && myS.empty())
            {
                flag = false;
            }
            
            
            //If closing bracket matches starting bracket then pop.
            if(s.charAt(i)=='}' && !myS.empty() && myS.peek() == '{')
            {
                myS.pop();
            }
            
            if(s.charAt(i)==')' && !myS.empty() && myS.peek() == '(')
            {
                myS.pop();
            }
            
            if(s.charAt(i)==']' && !myS.empty() && myS.peek() == '[')
            {
                myS.pop();
            }
            
           
        }
        
        //Return true if stack is empty and if once it had elements.
        if(myS.empty() && flag == true)
        {
            return true;
        }
        
        //Return false otherwise.
        return false;
    }
}