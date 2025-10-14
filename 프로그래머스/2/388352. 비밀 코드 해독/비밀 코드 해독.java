// import java.util.*;

// class Solution {    
//     boolean[] visited;
//     TreeSet<Integer> set = new TreeSet<>(); 
//     int answer = 0;
//     public int solution(int n, int[][] q, int[] ans) {
//         visited = new boolean[n+1];
        
//         combi(0,0,n,q,ans);
//         //validate( q, ans);
        
//         return answer;
//     }
    
//     public void combi(int cnt, int start, int N, int[][] q, int[] ans){
//         if(set.size() == 5){
//             if(validate(q, ans)) answer++;; 
//             return;
//         }
        
//         for(int i = start ; i < N ; ++i){
//             set.add(i+1);
//             combi(cnt+1, i+1, N, q, ans);
//             set.remove(i+1);
//         }
//     }
    
//     public boolean validate(int[][] q, int[] ans){
//         int qSize = q.length;
        
//         for(int i = 0 ; i < qSize ; ++i){
//             int sameCnt = 0;
            
//             for(int j = 0 ; j < 5 ; ++j){
//                 if(set.contains(q[i][j]))sameCnt++;
//             }
//             if(sameCnt != ans[i]) return false;
//         }
        
//         return true;
//     }
// }

import java.util.*;

class Solution {    
    boolean[] visited;
    TreeSet<Integer> set = new TreeSet<>(); 
    int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {
        visited = new boolean[n+1];
        
        combi(0,0,n,q,ans);
        //validate( q, ans);
        
        return answer;
    }
    
    public void combi(int cnt, int start, int N, int[][] q, int[] ans){
        if(set.size() == 5){
            if(validate(q, ans)) answer++;; 
            return;
        }
        
        for(int i = start ; i < N ; ++i){
            set.add(i+1);
            combi(cnt+1, i+1, N, q, ans);
            set.remove(i+1);
        }
    }
    
    public boolean validate(int[][] q, int[] ans){
        int qSize = q.length;
        
        for(int i = 0 ; i < qSize ; ++i){
            int sameCnt = 0;
            
            for(int j = 0 ; j < 5 ; ++j){
                if(set.contains(q[i][j]))sameCnt++;
            }
            if(sameCnt != ans[i]) return false;
        }
        
        return true;
    }
}