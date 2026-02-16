import java.util.*;

class Solution {
    ArrayDeque<int[]> list = new ArrayDeque<>();
    
    public ArrayDeque<int[]> solution(int n) {
        
        hanoi(n,1,2,3);
        return list;
    }
    
    public void hanoi(int n, int start, int tmp, int to){
        if(n == 1){
            list.add(new int[]{start, to});
            return;
        }
        
        //하노이탑이 A, B, C에 위치했을 때 
        
        //N-1 개를 A에서 B로 이동 시킨다.
        hanoi(n -1, start, to, tmp);
        
        //1개를 A -> C로 옮긴다.
        list.add(new int[]{start, to});
        
        //N-1개 B에있는 것을 C로 옮긴다.
        hanoi(n -1, tmp, start, to);
    }
}