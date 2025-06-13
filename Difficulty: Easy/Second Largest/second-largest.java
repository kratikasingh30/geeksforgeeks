class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int max = arr[0];
        int smax =-1;
        for (int i =0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        
        } 
        for(int i = 0 ;i<arr.length;i++){
            if(arr[i]<max &&arr[i]>smax){
                smax=arr[i];
            }
            
        }
        if(max==smax){
            return -1;
        }
        else{
            return smax;
        }
}
}