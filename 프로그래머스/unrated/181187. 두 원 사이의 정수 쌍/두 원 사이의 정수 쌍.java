class Solution {
    public long solution(int r1, int r2) {
        //각 사분면 사이에 위치한 정수 좌표
        long answer =0;

        //새로운 풀이
        // x^2 + y^2 = r^2 -> r들은 제공되고, y : 1 ~ r2-1까지 제공 되므로 x를 구할 수 있다.
        // 즉, x1^2 = r1^2 - y1^2, x2^2 = r2^2 - y2^2 구하기
        // x1 ~ x2 사이의 정수만 구하면 끗...

        // 유효한 정수 값은 x1보다 큰 정수값 x2보다 작은 정수값
        // x1 보다 크다 -> 올림
        // x2 보다 작다 -> 내림

        for(int y = 1 ; y < r2 ; ++y){
            //다음과 같이 y값에 따른 x좌표의 값을 구할 수 있다.
            double x1Sqrt = Math.sqrt(Math.pow(r1, 2) - Math.pow(y, 2));
            double x2Sqrt = Math.sqrt(Math.pow(r2, 2) - Math.pow(y, 2));
            
            
            //각 x좌표는 4개의 경우를 가진다.
            // 1. r1 : 1.xxx r2: 3.xxx -> 유효좌표는 2,3
            // 2. r1 : 1     r2: 3.xxx -> 유효좌표는 1,2,3
            // 3. r1 ; 1.xxx r2: 3     -> 유효좌표는 2,3
            // 4. r1 : 1,    r2: 3     -> 유효좌표는 1,2,3
            // 사례를 정리해보면 r1이 정수일 경우 유효좌표는 1,3대기 1개의 값을 더 가지게 된다.
            
            long cnt = (long) x2Sqrt - (long) x1Sqrt;
            if(x1Sqrt == (long) x1Sqrt) cnt++;
            
            answer += cnt;
        }

        return ( (r2-r1) + answer) * 4;
    }
}