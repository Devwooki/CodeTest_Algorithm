import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        //friend별 고유 idx 지정
        HashMap<String, Integer> myIdx = new HashMap<>();
        
        int idx = 0;
        for(String str : friends){
            myIdx.put(str, idx++);
        }
    
    
        int size = friends.length;
        int[][] history = new int[size][size];
        int[] gvPntSum = new int[size];
        int[] tkPntSum = new int[size];
        
        //선물주고받은 내역 저장
        for(String gift : gifts){
            String[] temp = gift.split(" ");
        
            int giver = myIdx.get(temp[0]);
            int taker = myIdx.get(temp[1]);
            
            history[giver][taker] += 1;
            gvPntSum[giver] += 1;
            tkPntSum[taker] += 1;
        }
    
        //결과값 계산
        int answer = 0;
        
        for(int i = 0 ; i < size ; ++i){
            int myGiftCnt = 0;
            int myPnt = gvPntSum[i] - tkPntSum[i];
            for(int j = 0 ; j < size ; ++j){
                if(i == j) continue;
                
                int otherPnt = gvPntSum[j] - tkPntSum[j];
                
            
                //주고받은 수가 같다면 지수 더 큰 사람이 작은사람에게 선물 받음
            
                if(history[i][j] > history[j][i]) myGiftCnt++;
                if(history[i][j] == history[j][i] && myPnt > otherPnt ) myGiftCnt++;
            
            }
            answer = Math.max(answer, myGiftCnt);
        }
        return answer;
    }
}