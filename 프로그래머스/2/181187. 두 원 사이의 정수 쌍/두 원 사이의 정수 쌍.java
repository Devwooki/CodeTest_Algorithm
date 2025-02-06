class Solution {
    public long solution(int r1, int r2) {
        
        long cnt = 0;
        
        for(int x = 1 ; x <= r2 ; ++x){
            //정수를 찾아야하니 외각에 위치한 좌표는 항상 내림
            double y2 = Math.floor(Math.sqrt(Math.pow(r2,2) - Math.pow(x,2)));
            
            //정수를 찾아야하니 내부에 위치한 좌표는 항상 올림
            double y1 = Math.ceil(Math.sqrt(Math.pow(r1,2) - Math.pow(x,2)));
            if(x >= r1){
                y1 = 0;
            }

            cnt += (long) y2 - (long) y1 + 1 ; 
            //System.out.println(y2 + ", " + y1 + " = " + ((long) y2 - (long) y1 + 1));
        }
        
        
        //return answer;
        return cnt * 4 ;
    }
}