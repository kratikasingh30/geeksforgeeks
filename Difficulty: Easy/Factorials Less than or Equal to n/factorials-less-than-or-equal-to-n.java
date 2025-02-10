//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long N = sc.nextLong();

            Solution ob = new Solution();
            ArrayList<Long> ans = ob.factorialNumbers(N);
            for (long num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java



class Solution {
    static ArrayList<Long> factorialNumbers(long n) {
        return findFactorial(1, 1, n, new ArrayList<>());
    }

    private static ArrayList<Long> findFactorial(long i, long fact, long n, ArrayList<Long> list) {
        if (fact > n) return list; // Base case: Stop if factorial exceeds n
        list.add(fact); // Add factorial to list
        return findFactorial(i + 1, fact * (i + 1), n, list); // Recursive call
    }}