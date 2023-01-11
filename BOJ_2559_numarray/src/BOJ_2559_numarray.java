import java.io.*;
import java.util.*;

public class BOJ_2559_numarray{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] sumarr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; ++i){
            arr[i] = Integer.parseInt(st.nextToken());
            sumarr[i+1] = sumarr[i] + arr[i];   //누적합 계산
        }

        int max = Integer.MIN_VALUE;
//        for(int i = 0 ; i < N-K+1 ; ++i){
//            int tempSum =0;
//            for(int k = 0 ; k < K ; ++k){
//                tempSum += arr[i+k];
//            }
//            max = Math.max(tempSum, max);
//        }
        for(int i = 0 ; i < N-K+1 ; ++i){
            max = Math.max(max,sumarr[i+K] -sumarr[i]); //i에서  j까지 구간합  -> s[j]-s[i-1]
        }

        System.out.print(max);

    }
}