import java.util.*;
class Solution {        //다리에 올라갈 수 있는 트럭 수, 다리의 최대 하중, 트력 무게들
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        //1초에 1칸 앞으로 갈 수 있다.
        
        Queue<Integer> q = new LinkedList<>();
        
        int bridgeW = 0;
        int idx = 0;
        int time = 0;
    
        for(int w : truck_weights){
            while(idx < truck_weights.length){
                if(q.isEmpty()){                        //큐가 비어있을 때 트럭을 추가한다.
                    q.offer(w);
                    bridgeW += w;
                    time++;
                    break;
                }else if(q.size() == bridge_length){    //다리가 가득 찬 경우 하나 뺀다.
                    bridgeW -= q.poll();
                }else{                                  //큐가 1개이상 차있음
                    if(bridgeW + w > weight){           //다음 트럭이 들어올 때 무게 초과
                        q.offer(0);                     //빈 트럭을 넣어서 
                        time++;
                    }else{                              ////다음 트럭이 들어올 때 탈 수 있음
                        q.offer(w);
                        bridgeW += w;
                        time++;
                        break;
                    }
                }
            }
        }
        return time + bridge_length;
    }
}