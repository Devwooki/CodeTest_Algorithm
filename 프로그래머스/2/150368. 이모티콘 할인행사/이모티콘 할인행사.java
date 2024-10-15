import java.util.*;

class Solution {
    //우선순위
    // 1. 이모티콘 플러스 서비스 가입자를 최대한 늘리는 것.
    // 2. 이모티콘 판매액을 최대한 늘리는 것.
    // n명의 사용자들에게 이모티콘 m개 할인해서 판매
    // 할인율 : 10, 20, 30, 40
    
    //사거나 가입하는 기준
    // 구매 : 기준에 따라 일정비율 이상 모두 구매
    // 가입 : 구매 비용의 합이 일정 가격 이상일 경우 구매 취소, 플러스 가입
    
    //가입자 수를 최대한으로 판매액 늘리기

    /* 1. 가입자수를 최대로 고려한다.
    경우의 수는 최대 4^7이다. 1만7천쯤...?
    
    경우에 수에 따라 이모티콘 구매비용 계산
        - 구매비용이 임계치(users[i][0])이상이면 합계 빼고 가입자수 입력
        - 구매비용이 임계치 미만 -> 구매 합계
    
    */
    int N, R;
    int[] discounts;
    int[][] usersCopy;
    int[] emoticonsCopy;
    PriorityQueue<int[]> pq;
    public int[] solution(int[][] users, int[] emoticons) {
        
        //idx 0 -> 가입자수
        //idx 1 -> 구매금액
        //가입자수가 동일하면, 판매액이 높은 것을 우선순위로 둔다
        pq = new PriorityQueue<>((o1, o2) -> {
            
            if(o1[0] == o2[0]) return Integer.compare(o2[1], o1[1]);
            return Integer.compare(o2[0], o1[0]);
        });
        
        usersCopy = users;
        emoticonsCopy = emoticons;
        
        N = users.length;
        R = emoticons.length;
        discounts = new int[R];
        
        perm(0);
        
        
        return pq.poll();
    }
    
    public void perm(int cnt){
        if(cnt == R){
            calc();
            return;
        }
        
        for(int i = 1 ; i <= 4; ++i){
            discounts[cnt] = i * 10; //이모티콘 별 
            perm(cnt+1);
        }
        
    }
    
    public void calc(){
        //인원별로 총 구매 금액 구한다.
        int[] payments = new int[N];
        for(int i = 0 ; i < N ; ++i){
            for(int j = 0 ; j < R ; ++j){
                //사용자가 생각하는 할인율 이상인 경우 구매
                if(usersCopy[i][0] <= discounts[j])
                    payments[i] += emoticonsCopy[j] 
                                    * (100 - discounts[j])
                                    / 100;
            }
        }
        
        //현재 할인비율의 가입자 수와 총 구매액을 구한다.
        int subCnt = 0;
        int total = 0;
        for(int i = 0 ; i < N ; ++i){
            //구매액이 사용자 임계치 이상일 경우 가입한다
            //그렇지 않을 경우 총 구매액
            if(usersCopy[i][1] <= payments[i]) subCnt += 1;
            else total += payments[i];
        }
        
        pq.offer(new int[]{subCnt, total});
    }
    
}