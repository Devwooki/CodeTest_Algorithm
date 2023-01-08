import java.io.*;
import java.util.*;

public class BOJ_1463_make1{
    public static int[] D;  // i를 1로만드는데 필요한 최소한 횟수
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        D = new int[N+1];
        int cnt = 0;

        //
        D[0] = D[1] = 0;
        for(int i = 2 ; i <= N ; ++i){
            D[i] = D[i-1]+1;//1씩 감소하는 연산을 먼저 저장
            if(i%2==0) D[i] = Math.min(D[i/2]+1, D[i]);  //n을  2로나눈것과 1로 뺀 것중에 최솟값저장
            if(i%3==0) D[i] = Math.min(D[i/3]+1, D[i]);  //n을  2로나눈것과 1로 뺀 것중에 최솟값저장
        }
        System.out.print(D[N]);

    }
}