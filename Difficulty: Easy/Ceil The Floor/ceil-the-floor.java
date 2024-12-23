//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] getFloorAndCeil(int k, int[] arr) {
         Arrays.sort(arr);
         int s=0;
        int e=arr.length-1;
        int floor=-1;
        int ceil=-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            
            if(arr[mid]<=k){
               floor=arr[mid];
               s=mid+1;
            }
            
            if(arr[mid]>=k){
                ceil=arr[mid];
                e=mid-1;
            }
        }
        int ans[]=new int[2];
        ans[0]=floor;
        ans[1]=ceil;
        return ans;
    }
}
