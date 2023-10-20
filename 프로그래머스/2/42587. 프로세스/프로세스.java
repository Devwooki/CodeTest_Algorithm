import java.util.*;
class Solution {
    static class MyProcess{
        int index;
        int priority;
        public MyProcess(int index, int priority){
            this.index = index;
            this.priority = priority;
        }
    }
    public int solution(int[] priorities, int location) {
        // priorities = new int[]{1,1,1,2};
        // location = 2;
        //우선순위대로 뽑는다
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (o2-o1));
        //현재 작업 프로세스 정리
        Queue<MyProcess> q = new LinkedList<>();       
        for(int i = 0 ; i < priorities.length ; ++i){
            pq.offer(priorities[i]);
            q.offer(new MyProcess(i, priorities[i]));
        }
        
        int cnt = 0;
        int nowPr = pq.poll();

        
        //location에 있는게 몇 번째로 실행되는가를 체크해야함
        while(!q.isEmpty()){
            MyProcess now = q.poll();
            
            if(now.priority < nowPr){//우선순위가 더 높은게 있으면 다시 작업 큐에 넣는다.
                q.offer(now);
            }else if(now.priority == nowPr){
                if(!pq.isEmpty()) {
                    nowPr = pq.poll();
                    cnt +=1;
                    if(now.index == location) break;
                }
            }
            System.out.println(now.index + ", " + now.priority + ", " + cnt );
        }
        
        return q.isEmpty() ? cnt+1 : cnt ;
    }
}