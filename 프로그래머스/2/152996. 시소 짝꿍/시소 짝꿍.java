import java.util.*;

class Solution {
    private long answer = 0;
    public long solution(int[] weights) {
        int SIZE = weights.length;
        int[] weightCnt = new int[1001];
        
        /*1. 오름차순 정렬 이유 : key(weights)는 무조건 증가한다.
            - key와의 비례식을 map에서 존재하는지 체크한 뒤 answer을 구할 수 있음
            - 다음 key(weight)의 비례식이 이전 key(weight)와 같을 수 있으니까
        */
        Arrays.sort(weights);
        
        
        Map<Double, Integer> map = new HashMap<>();
        double[] ratios = {
            1.0   //거리가 같음
            , 1.0/2.0 //거리 1:2(2:4)
            , 2.0/3.0 //거리 2:3
            , 3.0/4.0 //거리 3:4
        };
        for(int weight : weights){
            //weight의 비례식 결과를 계산한다.
            //map에 해당 값이 존재할 경우, 쌍을 이뤘기 때문에 answer에 더한다
            for(double ratio : ratios){
                double weightRatio = weight * ratio;
                if(map.containsKey(weightRatio)) answer += map.get(weightRatio);
            }
            map.put(weight*ratios[0], map.getOrDefault(weight*ratios[0], 0) + 1);    
        }
        
        return answer;
    }
}
/**
정렬   : 100  100  180  270  360
비율1  : 100  100  180  270  360 <--- 기준이 되는 값
-------------------------------
비율1/2:  50   50   90  135  180 
비율2/3:  66   66  120  180  240
비율3/4:  75   75  135  202  270
*/