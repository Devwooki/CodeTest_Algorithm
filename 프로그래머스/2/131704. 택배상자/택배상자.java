import java.util.*;

//보조 벨트는 앞 뒤로 이동이 가능하지만, 맨앞만꺼낼수 ㅣㅅ다
//가장 마지막에 넣은 것 부터 꺼냄 -> stack
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        int size = order.length;
        Queue<Integer> mainBelt = new ArrayDeque<>();
        Stack<Integer> subBelt = new Stack<>();
        
        for(int i = 0 ; i < size ; ++i){
            mainBelt.add(i + 1);
        }
        
        int odrIdx = 0;
        //작업 끝날 떄 까지 하는거지 뭐.. 
        while(true){
            boolean flag = false;
            
            //메인벨트 체크
            if(!mainBelt.isEmpty() && order[odrIdx] == mainBelt.peek()){
                odrIdx +=1;
                answer++;
                mainBelt.poll();
                flag = true;
                continue;
            }
            
            //보조벨트 체크
            if(!subBelt.isEmpty() && order[odrIdx] == subBelt.peek()){
                odrIdx += 1;
                answer++;
                subBelt.pop();
                flag = true;
                continue;
            }
            
            //둘다 해당안되면 작업이 불가하니 보조벨트로 옮기기
            if(!mainBelt.isEmpty()){
                subBelt.add(mainBelt.poll());
                flag = true;
            }
            
            if(!flag) break;
            
        }
        
        return answer;
    }
}