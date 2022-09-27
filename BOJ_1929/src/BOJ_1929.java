import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_1929 {
    //시간 복잡도 개선 및 코드 변경
    public static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        prime = new boolean[n+1];
        primeFilter();
        for (int i = m; i <= n; i++) {
            //if (check_sosu(i))
            //    System.out.println(i);
            if(!prime[i])
                System.out.println(i);
        }
    }

    // 제곱근 이하 자연수로 나누기 -> 기존 무차별 대입에서 약간 향상
    public static boolean check_sosu(int num) {
        if (num == 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }


    //에라토스테네스의 채 구현
    public static void primeFilter (){
        //0과 1은 소수가 아님
        prime[0] = true;
        prime[1] = true;
        for(int i = 2 ; i <= Math.sqrt(prime.length) ; i++){
            if(prime[i])//이미 걸러진 배열은 스킵
                continue;

            // 정석대로는 J= i*2 부터 시작이지만 2의 배수가 걸러져서 I의 제곱부터 시작해도 된다.
            for(int j = i * i; j < prime.length; j += i){
                prime[j] =  true;
            }
        }
    }
}