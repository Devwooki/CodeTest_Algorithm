import java.util.*;
class Solution {
    static class Feat{
        int progress;
        int speed;
        public Feat(int progress, int speed){
            this.progress = progress;
            this.speed = speed;
        }
    }
    public List<?> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new LinkedList<>();
        
        Queue<Feat> q = new LinkedList<>();
        for(int i = 0 ; i < progresses.length ; ++i){
            q.offer(new Feat(progresses[i], speeds[i]));
        }
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; ++i){
                Feat now = q.poll();
                now.progress += now.speed;
                q.add(now);
            }
            
            int cnt = 0;
            for(int i = 0 ; i < size ; ++i){
                if(q.peek().progress >= 100){
                    q.poll();
                    cnt+=1;
                } 
            }
            if(cnt!= 0) answer.add(cnt);
        }
        
        return answer;
    }
}