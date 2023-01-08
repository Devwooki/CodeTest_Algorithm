import java.io.*;
import java.util.*;

public class BOJ_1654_cutLANcable{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        for(int i = 0 ; i < K ; ++i){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        long lo = 1;
        long hi = arr[K-1];
        long mid;
        long cnt;
        while(lo <= hi){
            cnt = 0;
            mid = lo+((hi-lo)/2); //hi가 Max.value일 경우를 대비해서 lo와 hi사이 중앙점
            for(int i = 0 ; i<K ; ++i) cnt += (arr[i]/mid);


            /*[upper bound형식]
            mid 길이로 잘랐을 때  만들고자 하는 갯수보다 작으면 최대길이 줄임
            -> 그 외에는 자르고자 하는 길이를 늘려야하므로 최소길이 늘림
             */
            if(cnt < N)//너무 길게 자름
                hi = mid -1;
            else
                lo = mid+1;
        }
        //lo > hi가  되어 종료되었으므로 hi출력
        System.out.print(hi);

    }
}