import java.io.*;
import java.util.*;

public class BOJ_2018_squencesum{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //투 포인트로 문제 풀기
        int start_point = 1;
        int end_point = 1;
        int sum = 1;
        int result = 1;  //  start_point == end_point && start_point = N 일 때를 포함. 즉, N = 15일때 15하나만 뽑는 경우
        // start_point ~ end_point까지 구간 합을 구함
        while(end_point != N){
            if(sum == N){   //합과 N이 같으면 result++, endPoint를 늘려 다음 구간까지의 합도 구함
                result++;
                end_point++;
                sum += end_point;
            }else  if(sum < N){ //합 < N이면 더 더해야하므로 end_point 증가 시킨 후 더하기
                end_point++;
                sum += end_point;
            }else{  // 합 > N이면  범위가 큰 것이므로 start_point 증가시켜 범위 줄이기
                sum = sum - start_point;
                start_point++;
            }
        }
        System.out.println(result);
    }
}