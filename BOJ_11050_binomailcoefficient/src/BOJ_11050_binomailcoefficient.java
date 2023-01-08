import java.io.*;
import java.util.*;
/*
이항 계수 : 두 개의 항을 전개해 계수로 나타낸 것이다.
-> 즉 nCk가 되는 조합공식
 */
public class BOJ_11050_binomailcoefficient{
    public static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =  new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        dp =  new int [N+1][K+1];
        System.out.print(BC(N,K));
    }

    /*
    파스칼의  삼각형
    n+1Cr+1 = nCr + nCr-1
    ->
    n+1 =  n =   n
    r+1    r = r + 1
    -----------------
    n =  n-1 =  n-1
    r    r-1 =   r  으로 변환 할 수 있다 따라서
     */
    public static long BC(int n, int k){
        //이미 풀었던 sub는 그대로 반환
        if(dp[n][k]>0) return dp[n][k];

        //(n,r) || (n, 0 ) = 1이기 때문에
        if(n ==  k || k == 0){
            dp[n][k] = 1;
            return dp[n][k];
        }
        dp[n][k] = (int) (BC(n-1, k-1) + BC(n-1,k));
        return dp[n][k];
        //
        //  return dp[n][k] = (int) (BC(n-1, k-1) + BC(n-1,k)); 으로도 쓸 수 있음
        //
    }
}
