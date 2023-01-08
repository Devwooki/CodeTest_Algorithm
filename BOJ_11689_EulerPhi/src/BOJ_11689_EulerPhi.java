import java.io.*;
import java.util.*;

public class BOJ_11689_EulerPhi{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //자연수 n이 주어졌을 때 최대공약수가 1인  서로소의 갯구를 구하는 문제 -> 오일러의 피
        /*
        오일러의 피
        1. 오일러의 피 범위 만큼 배열 초기화
        2. 2부터 시작해서 p[i] = p[i] - p[i]/K; ( 2 <= K <= N)까지 배열끝까지 반복
         */
        int N = Integer.parseInt(br.readLine());
        int[] phi = new int[N+1];
        for(int i= 0 ; i <= N ; ++i){
            phi[i] = i;
        }

        if(N <= 1)
            System.out.println(N);
        else{
            for(int k = 2 ; k <= N ; ++k){
                int i = 1;
                while(true){
                    if((k*i) > N){
                        break;
                    }
                    phi[i*k] = phi[i*k] - (phi[i*k]/k);
                    i++;
                }
            }
            System.out.println(phi[N]);
        }


    }
}