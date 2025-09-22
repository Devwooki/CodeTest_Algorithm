import java.util.*;

class Solution {
    static int SIZE;
    public String[] solution(String[][] plans) {
        int answerIdx = 0;
        SIZE = plans.length;
        String[] answer = new String[SIZE];

        PriorityQueue<Plan> pq = new PriorityQueue<>((o1, o2) -> o1.startTime - o2.startTime);
        //plans는 시작 시각 순으로 정렬되어 있지 않아서 임의로 정렬한다.
        for(String[] plan : plans){
            pq.add(new Plan(plan[0], getTime(plan[1]), Integer.parseInt(plan[2])));
        }

        //가장 최근에 멈춘 과제를 꺼내기 위한 스택
        Stack<Plan> waitStack = new Stack<>();

        Plan cur = pq.poll();
        int nowTime = cur.startTime;

        while(true){

            //1. 새로운 과제(pq.peek().startTime)를 시작할 시간이 되었을 때
            //   기존 작업하던 과제가 있다면(cur) 진행 중 과제 멈추고 신규 과제 시작
            // pq가 비어있는지을 제일 우선으로 체크해야함을 주의
            if(!pq.isEmpty() && nowTime + cur.workTime > pq.peek().startTime ){
                int remainTime = cur.workTime - (pq.peek().startTime - nowTime);

                waitStack.push(new Plan(cur.name, cur.startTime, remainTime));
                nowTime = pq.peek().startTime;
                cur = pq.poll();
            }else{ //2. 진행중인 과제가 끝났을 때, 결과를 저장, 멈춘과제가 있다면(!stack.isEmpty()) 멈춘과제 시작

                answer[answerIdx++] = cur.name;
                nowTime +=  cur.workTime;

                // 과제를 끝낸 시각(nowTime)에 새로 시작해야 되는 과제(pq.peek())와 잠시 멈춰둔 과제(stack.peek())가 모두 있다면,
                // 우선순위 멈춘과제 <<<< 시작과제
                /* 작업 우선 순위
                *  1. 현재 시간에 새로운 과제 vs 중지 과제 : 새로운 과제 >>> 중지 과제
                *  2. 현재 시간에 새로운 과제 없고 중지 과제 : 최우선 중지 과제
                *  3. 중지 과제없고, 일정 시간 이후 과제 : 일정 시간 이후 과제, 시간 갱신 주의
                *  4. 없으면 종료
                * */
                if(!pq.isEmpty() && nowTime == pq.peek().startTime){// 새로운 과제
                    cur = pq.poll();
                } else if(!waitStack.isEmpty()) { //멈춘과제
                    cur = waitStack.pop();
                } else if( !pq.isEmpty()){ //다음 과제, 시간 갱신 주의
                    cur = pq.poll();
                    nowTime = cur.startTime;
                }else break; //이것도 아니면 종료
            }


        }
        
        //과제 끝낸 순서대로 반환하기
        return answer;
    }

    static int getTime(String date){
        StringTokenizer st = new StringTokenizer(date, ":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        return h * 60 + m;
    }

    class Plan{
        String name;
        int startTime;
        int workTime;

        public Plan(String name, int startTime, int workTime) {
            this.name = name;
            this.startTime = startTime;
            this.workTime = workTime;
        }
    }
}