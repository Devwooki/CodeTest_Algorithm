import java.util.*;
import java.io.*;
public class Main {
    public static long[] arr;
    public static long N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());
        arr = new long[(int)N];
        
        long hi = Long.MIN_VALUE;
        //lo를 안찾는 이유는 전부 다 최대로 잘라야할 수 있으니까
        for(int i = 0 ; i < N ; ++i){
            arr[i] = Long.parseLong(br.readLine());
            hi = Math.max(hi, arr[i]);
        }

        binSearch(1, hi);
    }
    public static void binSearch(long lo, long hi){

        while(lo <= hi){
            long mid = lo + (hi-lo)/2;//최저 + 최대 높이의 중간부터 탐색

            long cnt = getLAN(mid);

            if(cnt < K){
                hi = mid - 1 ;
            }else{
                lo = mid +1;
            }
        }
        System.out.println(hi);
    }
    //주
    public static long getLAN(long  len){
        long cnt = 0;
        for(int i = 0 ; i < N ; ++i) {
            cnt += (arr[i]/len);
        }
        return cnt;
    }
}

