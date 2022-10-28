import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2004_combination0 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long cnt2 = get5pow(n) - get5pow(n-m) - get5pow(m);
        long cnt5 = get2pow(n) - get2pow(n-m) - get2pow(m);
        //조합 nCm을 해서 0의 개수를 구하라
        // -> 0의 개수 = 10의 승수를 구하라 ->facto0 문제와 유사, 5의 개수가 결정지음
        // 조합  n!/(n-r)!r!에서 2와 5의 승수 구하기

        //두 값중 최솟값을 출력하면 됨됨
       System.out.println(Math.min(cnt2, cnt5));
    }


    //BOJ 1676응용
    public static long get5pow(long a){
        long cnt = 0;
        while(a >= 5){
            cnt += a/5;
            a /= 5;
        }
        return cnt;
    }
    public static long get2pow(long a){
        long cnt = 0;
        while(a >= 2){
            cnt += a/2;
            a /=2;
        }
        return cnt;
    }
}