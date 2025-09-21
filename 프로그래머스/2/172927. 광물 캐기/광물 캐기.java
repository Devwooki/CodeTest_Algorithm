import java.util.*;

class Solution {
    static List<Mineral> list = new ArrayList<>();
    static int[][] picksScore = {
        {1, 1, 1}, //다이아
        {5, 1, 1}, //철
        {25, 5, 1}  //돌
    };
    
    public int solution(int[] picks, String[] minerals) {
        
        int answer = 0;
        int mineralsSize = minerals.length;
        int totalPicks = Arrays.stream(picks).sum(); //반례 : 광물보다 곡괭이 수가 적으면 종료해야함
        
        //한 곡괭이당 5번씩 캘 수 있으므로 5개씩 묶음
        for(int i = 0 ; i < mineralsSize ; i+=5){
            if(totalPicks == 0) break;
            
            int dia = 0;
            int iron = 0;
            int stone = 0;
            
            for(int j = i ; j < i + 5 ; ++j){
                //길이를 초과하면 에러가 나므로 
                if(j == mineralsSize) break;
                
                //광물 별, 특정 곡괭이로 광물을 캤을 때의 점수를 사전에 계산한다.
                int mineral = -1 ;
                if(minerals[j].equals("diamond")) mineral = 0;
                else if(minerals[j].equals("iron")) mineral = 1;
                else if(minerals[j].equals("stone")) mineral = 2;
                
                dia += picksScore[0][mineral];
                iron += picksScore[1][mineral];
                stone += picksScore[2][mineral];
            }
            //경우의 수를 입력한다.
            list.add(new Mineral(dia, iron, stone));
            totalPicks--;
        }
        
        //정렬한다. 최악의 순(돌 곡괭이로 캐는 경우 피로도가 가장 높음)으로 내림차순 정렬
        list.sort((o1, o2)-> (o2.stone - o1.stone));
        //-> 돌 곡괭이로 캤을 때 피로도가 높다 == 다이아나 철이 많다.
        //모든 광물을 다 캘 때 까지 최상의 곡괭이로 점수를 구한다
        for(Mineral m : list){
            int dia = m.dia;
            int iron = m.iron;
            int stone = m.stone;
            
            if(picks[0] > 0){//다이아로 캘 수 있으면 다이아로 캐서 계산
                picks[0] -= 1;
                answer += dia;
                continue;
            }
            
            if(picks[1] > 0){//다이아로 캘 수 있으면 다이아로 캐서 계산
                picks[1] -= 1;
                answer += iron;
                continue;
            }
            
            if(picks[2] > 0){//철로 캔다는 것은... 이미 거의 끝자락이란 이야기
                picks[2] -= 1;
                answer += stone;
                continue;
            }
        }
        
    
        return answer;
    }
    
    
    
    class Mineral{
        int dia;
        int iron;
        int stone;
        
        public Mineral(int dia, int iron, int stone){
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
    }
}