class Solution {
    /**
    누적합을 활용해 해결하자
    startTime은 1,
    endTime에 -1을 지정한 뒤 값을 누적하면
    현재 예약중인 방의 수를 알 수 있다.
    
    인덱스 : 0  1  2  3  4  5  6  7  8  9  10
    값1   :    1             -1
    값2   :    1                      -1
    누적합 : 0  2  2  2  2  2  1  1  1  0  0
    */
    int SIZE = 24 * 60 + 10;
    int[] reserveState;
    public int solution(String[][] book_time) {
        reserveState = new int[SIZE];
        changeTime(book_time);
        
        int answer = Integer.MIN_VALUE;
        
        for(int i = 1 ; i < SIZE ; ++i){
            reserveState[i] += reserveState[i-1];
            answer = Math.max(reserveState[i], answer);
        }
        return answer;
    }
    
    public void changeTime(String[][] book_time){
        for(String[] time : book_time){
            String[] start = time[0].split(":");
            String[] end = time[1].split(":");
            
            int startTm = Integer.parseInt(start[0]) * 60
                            + Integer.parseInt(start[1]);
            int endTm = Integer.parseInt(end[0]) * 60
                            + Integer.parseInt(end[1]) + 10;//청소시간 포함
            
            reserveState[startTm]++;
            reserveState[endTm]--;
        }
    }
}