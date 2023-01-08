import java.io.*;
import java.util.*;

public class BOJ_1003_fibo{
    public static int[][] D;
    public static int cnt0= 0;
    public static int cnt1= 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        D = new int[41][2];
        D[0][0] = 1;
        D[0][1] = 0;
        D[1][0] = 0;
        D[1][1] = 1;
        for(int i = 2 ; i < 41 ;++i){
            D[i][0] = D[i-1][0] + D[i-2][0];
            D[i][1] = D[i-1][1] + D[i-2][1];
        }
        for(int i = 0 ; i < TC ; ++i){
            int x = Integer.parseInt(br.readLine());
            sb.append(D[x][0]+ " " + D[x][1]+"\n");
        }
        System.out.print(sb);

    }

    public static int fibo(int n){
        if(n == 0){
            cnt0++;
            return 0;
        }else if(n == 1){
            cnt1++;
            return 1;
        }
        return fibo(n-1) + fibo(n-2);
    }
}