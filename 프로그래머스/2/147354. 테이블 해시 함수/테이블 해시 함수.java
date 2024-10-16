import java.util.*;

/* 테이블이 정수타입
i : 튜플(row)
j : 컬럼

첫 번째 컬럼은 PK -> 중복X

1. col 번째 컬럼을 기준으로 오름차순 정렬, 동일할 경우 첫 컬럼 기준 내림차순
*/
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        //data 정렬하기
        ArrayList<int[]> list = new ArrayList<>();
        
        for(int[] tuple : data){
            list.add(tuple);
        }
        
        Collections.sort(list, (o1, o2) ->{
            //col의 값이 같으면 pk내림차순
            if(o1[col-1] == o2[col-1]) return Integer.compare(o2[0], o1[0]);
            //col값 기준 오름차순
            return Integer.compare(o1[col-1], o2[col-1]);
        });
        
        int tupleLen = data[0].length;
        for(int i = row_begin -1 ; i < row_end ; ++i){
            
            //각 컬럼의 값을 i로 나눈 나머지들의 합 구하기.
            int[] curr = list.get(i);
            
            int subSum = 0;
            for(int j = 0 ; j < tupleLen ; ++j){
                subSum += (curr[j] % (i+1));
            }
            
            answer ^= subSum;
        }
            
        return answer;
    }
}