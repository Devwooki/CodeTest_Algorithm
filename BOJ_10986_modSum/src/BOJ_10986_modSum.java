import java.io.*;
import java.util.*;

public class BOJ_10986_modSum{
    public static void main(String[] args) throws IOException{
        // (A+B)%C == (A%C) + (B%C) -> 특정 구간 수들의 나머지 연산을 더한것 == 구간 합의 나머지 연산
        // 구간 합 배열에서  j부터 i까지의 합 =>  sum[j] - sum[j-1]
        // sum[i]%M == sum[j]%m ->  (sum[i] - sum[j]) % M = 0,
        // 즉 구간 합 배열의 원소를 M으로 나눈 나머지로 업데이트 후 s[i]와 sum[j]가 같은 것을 찾으면 J+1 ~ i까지 구간합이 M으로  나눠떨어짐
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long[] arr = new long[(int)N+1];
        long[] cnt = new long[(int) M];
        long result = 0;

        st = new StringTokenizer(br.readLine(), " ");
        //누적합을 구함함
        for(int i = 1 ; i <= N ; i++){
            //누적합을 배열에 저장
            long num = Long.parseLong(st.nextToken());
            arr[i] = arr[i-1] + num;

            //누적합의 나머지가 0이면 result++;
            if(arr[i] %M == 0) result++;
            //같은 나머지의 개수 cnt배열에 저장, cnt배열의 길이 = M보다  작은 자연수
            cnt[(int)(arr[i]%M)]++;

        }
        //i가  나머지인 인덱스의  개수에서 2가지를 뽑는 경우의 수  정답에 더하기
        for(int i =  0 ; i < M ; i++){
            result += (cnt[i] * (cnt[i]-1)/2);
        }
        System.out.println(result);
    }

}