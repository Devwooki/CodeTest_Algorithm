import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1676_facto0 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int cnt = 0;
        //뒷자리가 0이 나오는 경우? 2x5 일 때! ->  소인 수 분해해서 2,5가 존재하면 뒷자리가 0임
        //ex 10! = 10(=2*5) 9 8 7 6 5 4 3 2 1 = 120-> 2^8와 5^2 외 여러개로 구성 개 ->  10이 2개나옴
        //   15! = 15(=3*5) 14 13 12 11 10(=2*5) 9 8 7 6 5 4 3 2 1 -> 2^11, 5^3개 -> 10이 3개나옴
        // 5로 나눠지는 몫을 더해주기
        while(num >= 5){
            cnt += num/5;
            num /= 5;
        }

        System.out.println(cnt);

    }
    public static long myFacto(int n){
        if( n == 0 || n == 1) return 1;
        return n * myFacto(n-1);
    }
}
