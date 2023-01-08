import java.io.*;
import java.util.*;

public class BOJ_1747_primePelin{
    public static boolean[] isPrime;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        getPrime();
        while(true){
            String str_N = String.valueOf(N);
            if(!isPrime[N] && isPelin(str_N)){
                break;
            }else N++;

        }

        System.out.print(N);

    }
    public static void getPrime(){
        isPrime = new boolean[10000001];
        //false면 소수
        isPrime[0] = isPrime[1] = true;
        for(int i = 2; i <= Math.sqrt(isPrime.length) ; ++i){
            if (isPrime[i]) continue;
            for(int j = i * i ; j < isPrime.length ; j +=i)
                isPrime[j] = true;
        }
    }

    public static boolean isPelin(String str){
        int len = str.length();
        for(int i = 0 ; i < len/2 ;++i){
            if(str.charAt(i) != str.charAt(len-1-i))
                return false;
        }
        return true;
    }
}
