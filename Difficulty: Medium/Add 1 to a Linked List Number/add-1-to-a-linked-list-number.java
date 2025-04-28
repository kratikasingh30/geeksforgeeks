//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        
        Node newHead = reverse(head);
        Node curr = newHead;
        Node prev= null;
        int carry=0;
        while(curr!=null){
            int sum =0;
            if(prev==null){
                sum = curr.data+1;
            }
            else{
                sum=curr.data+carry;
            }
            carry = sum/10;
            sum = sum%10;
            curr.data=sum;
            prev=curr;
            curr=curr.next;
        }
        if (carry==1){
            Node newNode = new Node(1);
            prev.next = newNode;
        }
        
    return reverse(newHead);
    }
    public Node reverse(Node head){
        Node prev = null;
        Node current = head;
        while(current!=null){
            Node front = current.next;
            current.next =prev;
            prev=current;
            current=front;
        }
        return prev;
    }
   
}
