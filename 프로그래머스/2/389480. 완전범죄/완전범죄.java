import java.util.*;

/* 한 번 흔적을 남길 때 1 ~ 3개
    A는 n개 이상이면 잡힘
    B는 m개 이상이면 잡힘
    
    두 도둑이 모두 잡히지 않도록 물건을 훔쳤을 때, a도둑이 남긴 흔적 누적 수
    두 도둑 모두 경찰에 붙잡히지 않게 할 수 없다면 -1
    
    다만 a가 훔쳤을 때 최솟값을 return 하도록 해야함
*/
class Solution {
    int answer = Integer.MAX_VALUE;
    int N;
    int M;
    public int solution(int[][] info, int n, int m) {
        this.N = n;
        this.M = m;
        int sumB = 0;
        for(int[] evidence : info){
            sumB += evidence[1];
        }
        
        //백트래킹 풀이
        //thief(info, 0, 0, sumB);
        //return answer == Integer.MAX_VALUE ? -1 : answer;
        
        return getDP(info);
    }
    
    //선택한 요소에 대해 검증을하는 백트래킹으로 구현하려 했지만 2^40개의 조합이 발생
    //백트래킹 풀이 -> 
    public void thief(int[][] info,int cur, int sumA, int sumB){
        if(sumA >= answer) return; //sumA가 현재 훔친 수보다 크면 의미없음
        if(sumA < N && sumB < M){
            answer = Math.min(answer, sumA);
            return;
        }
        
        if(cur == info.length) return; //끝까지도달했으니 종료
        thief(info, cur+1, sumA, sumB); //현재 선택안함
        thief(info, cur+1, sumA + info[cur][0], sumB - info[cur][1]); //현재 선택함
    }
    
    //DP로 해결해야함 
    public int getDP(int[][] info){
        //Integer.MAX_VALUE를 하니 오버플로우가 발생함
        int INF = 10000000;
        int size = info.length;
        
        //DP[x][y] = z : 훔친 물건이 x개일 때 b가흘린 흔적의수 y 때 a의 최소흔적
        // B는 m개 미만으로 훔칠 수 있음에 주의하자
        int[][] dp = new int[size + 1 ][M]; 
        
        for(int i = 0 ; i <= size ; ++i){
            Arrays.fill(dp[i], INF);
        }
        
        dp[0][0] = 0;
        for(int i = 1 ; i <= size ; ++i){
            int a = info[i-1][0];
            int b = info[i-1][1];
            
            /*B가 흘린 흔적의 수를 고려한다
            i 번째에서 
                A가 훔치면 a
                B가 훔치면 b
            */
            for(int j = 0 ; j < M ; ++j){
                //A가 훔침
                //B가 남긴 흔적 수(J)는 이전물품그대로고, A는 이전 + a만큼
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + a);
                
                //B가 훔침 - (j : 지금까지 B가 남긴 흔적)
                //B가 남긴흔적(j+b)와 A의 이전 값을 가져온다
                if(j + b < M)
                    dp[i][j + b] = Math.min(dp[i][j + b], dp[i-1][j]);
            }
        }
        
        int answer = INF;
        //모든 물건을 훔친상태에서 a의 최소 적을 찾음
        for(int j = 0 ; j < M ; ++j){
            answer = Math.min(dp[size][j], answer);
        }
        
        return answer >= N ? -1 : answer; //a가 훔친게 N보다 크면 불가능함
    }
}