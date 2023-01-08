import java.io.*;
import java.util.*;

public class BOJ_11047_minestCoin{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N =  Integer.parseInt(st.nextToken());
        int M =  Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        for(int i = 0; i < N ; ++i){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for(int i = N-1 ;  i >= 0 ; --i){
            if(M > coins[i]){
                cnt += M/coins[i];
                M = M%coins[i];
            }

            if(M == 0) break;
        }

        System.out.print(cnt);
    }
}