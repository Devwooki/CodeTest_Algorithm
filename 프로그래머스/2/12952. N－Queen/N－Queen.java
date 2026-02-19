import java.util.*;

class Solution{
    int[] map;
    int N;
    int answer= 0;
    public int solution(int n){
        map = new int[n];
        N = n;
        
        nqueen(0);
        return answer;
    }
    
    public void nqueen(int cnt){
        if(cnt == N){
            answer++;
            return;
        }
    
        for(int i = 0 ; i < N ; ++i){
            // (cnt,i)위치에 퀸을 둔다
            map[cnt] = i;
            
            //퀸의 위치가 유효하면 패스
            if(isValid(cnt)) nqueen(cnt + 1);
        }
    }
    
    public boolean isValid(int cnt){
        //cnt까지만 검사한다.
        for(int i = 0 ; i < cnt ; ++i){
            
            //행 - map의 각 인덱스위치에 퀸을 놓으므로, 행을 검사할 필요는 없다.
            
            //열 - 같은 열에 있으면 잡을 수 있으므로 패스
            if(map[i] == map[cnt]) return false;
            
            //대각선 검사 - x1,y1 ~ x2, y2의 거리가 같으면 대각선에 있으므로 패스
            if(Math.abs(map[i] - map[cnt]) == Math.abs(i - cnt)) return false;
            
        }
        
        //중복 검사에서 걸리지 않았으므로 패스
        return true;
    }
}



// class Solution {
//     int[] map;
//     int GLOBAL_N;
//     int answer = 0;
//     public int solution(int n) {
//         GLOBAL_N = n;
        
//         map = new int[n];

//         nQueen(0);
        
//         return answer;
//     }
    
//     public void nQueen(int cnt){
//         //배열 끝까지도달하면 nqueen 달성한 것이니 종료
//         if(cnt == GLOBAL_N){
//             answer++;
//             return;
//         }
        
//         for(int i = 0 ; i < GLOBAL_N ; ++i){
//             //체스를 배치한다
//             map[cnt] = i;
            
//             //배열한 체스판이 이상없으면 진행한다.
//             if(isVaild(cnt)){
//                 nQueen(cnt+1);
//             }
//         }
        
//     }
    
//     //2차원 배열을 1차원으로 초기화 하여 생각하자
//     public boolean isVaild(int cnt){
        
//         //이전 col을 체크한다.
//         for(int i = 0 ; i < cnt ; ++i){
//             //cnt와 i는 항상 다름
            
//             //같은 row에 있어서 패스
//             if(map[cnt] == map[i]) return false;
//             //서로 대각선에 있어서 패스
//             if(Math.abs(map[cnt] - map[i]) == Math.abs(cnt - i)) return false;   
//         }
        
//         return true;
//     }
// }