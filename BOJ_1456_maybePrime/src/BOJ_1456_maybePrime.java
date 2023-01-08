import java.io.*;
import java.util.*;

public class BOJ_1456_maybePrime{
    public static  boolean[] isPrime;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long A =  Long.parseLong(st.nextToken());
        long B =  Long.parseLong(st.nextToken());

        getPrime();
        int result =  0;
        for(long i = 2; i < 10000001 ; ++i){
            // B는 최대 10^14 -> sqrt(B) = 10^7승까지니까 10000001까지  반복시킴
            /*
            즉 sqrt(B)이하의 모든 소수를 N제곱(N>=2)해서 [A,B]범위 안에 있는 것을 찾으면 됨
             */
            if(!isPrime[(int) i]){//소수를 찾으면 소수의 K제곱이 A,B사이에 있는지 파악
                long temp = i * i;
                while(temp <= B){
                    if(A <=temp){
                        result++;
                    }
                    temp *= i; //  i^N승

                    if(temp%i != 0) break;
                    /*
                    만약 i가 10^7에 근접한 소수일 경우 B= 10^14이다.
                    p*p <  B이겠지만 p^3은  10^21과 유사하므로  범위를 벗어나게됨
                    ->  예외 처리 잘 하는게 문제풀이 핵심
                     */
                }
            }
        }


        System.out.print(result);

    }

    public static void getPrime(){
        isPrime = new boolean[10000001];
        //false == 소수
        isPrime[0] = isPrime[1] = true;
        for(int i = 2 ; i <= Math.sqrt(isPrime.length) ; ++i){
            if(isPrime[i]) continue;
            for(int j =  i*i ; j < isPrime.length; j += i){
                isPrime[j] = true;
            }
        }
    }
}



