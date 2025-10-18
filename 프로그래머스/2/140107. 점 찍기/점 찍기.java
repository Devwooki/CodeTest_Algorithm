class Solution {
    boolean[][] map;
    
    public long solution(int k, int d) {
        long answer = 0;
        
//         for(int a = 0 ; a <= d ; ++a){
//             for(int b = 0 ; b <= d ; ++b){
//                 //거리가 D 이하
//                 int ak = a * k;
//                 int bk = b * k;
                
//                 // System.out.println(a+ ", " + b + " : " + Math.sqrt(Math.pow((ak - 0), 2) + Math.pow((bk - 0), 2)));
//                 if(Math.sqrt(Math.pow((ak - 0), 2) + Math.pow((bk - 0), 2)) <= (double) d) answer++;
//             }
//         }
        
        // 2중 for문은 완전 탐색으로 시간 초과가 발생한다.
        // 원의 특성을 고려하여.. 수학적으로 계산하도록
        
        for(int a = 0 ; a <= d ; a += k){//a를 k만큼 더하면서 y의 값을 구하기 위함
            //ak값을 통해 d거리 이하의 최대 Y값을 유추할 수 있다.
            //long maxY = (long)Math.sqrt(d*d - a*a); 
            long maxY = (long) Math.sqrt(Math.pow(d, 2) - Math.pow(a, 2));
            
            answer += (long) maxY / k + 1 ;
            /*
            maxY 이하에서 k의 배수면 d이하의 거리를 충족시킴 -> maxY / k -> 유효한 값 수
            + 1 -> y값이 0인 경우에도 d이하의 거리를 충족 시키기 때문
            */
        }
        return answer;
    }
}