//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(new Solution().infixToPostfix(br.readLine().trim()));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String s) {
         StringBuilder result = new StringBuilder();
         Stack<Character> stack = new Stack<>();
         for(char ch : s.toCharArray()){
             if((ch>='A' && ch<='Z') || (ch>='a'&&ch<='z') ||(ch>='0'&&ch<='9')){
                 result.append(ch);
             }
             else if (ch=='('){
                 stack.push(ch);
             }
             else if (ch == ')') {  
                while (!stack.isEmpty() && stack.peek() != '(') {
                  result.append(stack.pop());
             }
               stack.pop(); // Remove '(' from stack
                      
             } 
         else { // Operator case
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
         }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    } 
    public static int precedence(char ch) {
        if (ch == '^') return 3;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '+' || ch == '-') return 1;
        return 0;
    }

}