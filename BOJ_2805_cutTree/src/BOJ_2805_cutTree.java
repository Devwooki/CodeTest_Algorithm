import java.io.*;
import java.util.*;

public class BOJ_2805_cutTree{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        int max = 0;
        for(int i = 0 ; i < N ; ++i){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        Arrays.sort(arr);

        long lo = 0;
        long hi = max;
        long mid;
        long sum;
        while(lo<=hi){
            sum = 0;
            mid = lo + ((hi-lo)/2);

            for(int i = 0 ; i < N ; ++i){
                if(arr[i] <= mid) continue;
                sum += (arr[i] - mid);
            }
            //절단기 설정할 수 있는 높이의 최댓값을 구함
            if(sum < M) hi = mid-1;
            else lo = mid+1;
        }

        System.out.print(hi);

    }
}