import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class BOJ_2108_retry {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()); // 수의 갯수
        StringBuilder sb =new StringBuilder();

        //입력값 배열에 삽입
        int[] arr = new int[num];
        for(int i = 0 ; i < num ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        for(int i = 0 ; i < num ; i++){
            System.out.print(arr[i] + ", ");
        }

        //산술 평균
        double sum = 0;
        for(int i = 0 ; i<num ; i++){
            sum += arr[i];
        }
        sum = Math.round(sum/num);
        sb.append((int)sum).append("\n");

        //중앙값 출력
        sb.append(arr[num/2]).append("\n");

        // 최빈값 출력 - 여러개 있을 때 두 번째로 작은 값 출력





        //범위 출력 : 최댓값 - 최솟값
        sb.append(arr[num-1]-arr[0]).append("\n");
        System.out.println(sb);
    } 

}