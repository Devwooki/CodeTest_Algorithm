import java.util.*;

class Solution {
    int TIME = 24;
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] opServ = new int[TIME];
        
        for(int i = 0 ; i < TIME ; ++i){
            int player = players[i];
            //현재 필요한 서버의 수
            int n = player / m;
            
            //현재 운영중인 서버 차이 만큼 가용한다.
            int extraServer = n - opServ[i];
            if(extraServer < 0 ) extraServer = 0;
            
            //현재 운용중인 서버로 감당 가능한가?
            if(isAvail(opServ[i], n)) continue;
            
            
            //k타임 만큼 서버 스케쥴링 등록
            for(int j = 0 ; j < k ; ++j){
                int time = i + j;
                if(time > 23) break;
                
                opServ[time] += extraServer;
            }
            
            answer += extraServer;
        }
        
        return answer;
    }
    
    private boolean isAvail(int opServ, int n){
        return ( n <= opServ ) && ( opServ < (n+1));
    }
}