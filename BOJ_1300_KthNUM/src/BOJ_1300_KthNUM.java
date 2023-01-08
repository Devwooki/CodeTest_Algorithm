import java.io.*;
import java.util.*;

public class BOJ_1300_KthNUM{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long K = Long.parseLong(br.readLine());

        long lo = 1;
        long hi = K;
        long result = 0;
        while(lo <= hi){
            long mid = (lo+hi)/2; //1 ~ N^N이지만  K번째 수는 K를 넘지 못함!!
            long smallthanMID = 0;

            //중앙값 보다  작은 수 cnt
            for(int i =  0 ; i < N ; ++i){
                smallthanMID += Math.min(mid/(i+1), N);
            }

            if(smallthanMID < K) lo = mid +1;
            else{
                hi = mid-1;
            }
        }
        System.out.print(lo);
        //중앙값보다 작거나 같은 수의 갯수가 K보다  적음 -> 시작인덱스 = 중앙값 +1;
        //중앙값보다 작거나 같은 수의 갯수가 K보다  큼 -> 종료인덱스 = 중앙값 -1;



    }
}