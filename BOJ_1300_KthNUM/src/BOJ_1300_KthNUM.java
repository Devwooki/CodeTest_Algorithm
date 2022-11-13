import java.io.*;
import java.util.*;

public class BOJ_1300_KthNUM{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        long[][] a =  new long[N][N];
        long[] b = new long[N*N];

        for(int i = 0 ; i < N ; ++i){
            for(int j = 0 ; j < N ; ++j)
                a[i][j] = (long) i * j;
        }
        StringBuilder sb = new StringBuilder();


    }
}