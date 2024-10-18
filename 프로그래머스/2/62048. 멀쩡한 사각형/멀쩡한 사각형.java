import java.util.*;

class Solution {
    public long solution(int w, int h) {
        long wL = (long) w;
        long hL = (long) h;
        long answer = 1;
        
        
        return wL * hL - (wL + hL - get최소공약수(wL,hL));
    }
    
    //최소공약수
    public long get최소공약수(long w, long h){
        long big = Math.max(w, h);
        long small = Math.min(w, h);
    
        while(small > 0){
            long temp = big%small;
            big = small;
            small = temp;
        }
        
        return big;
    }
}