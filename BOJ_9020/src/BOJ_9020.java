import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

//2보다 큰 모든 짝수는 소수의 합으로 나타낼 수 있다 : 골드바흐 수
// 짝수를 두 소수의 합으로 나타내는 표현을 골드바흐 파티션
public class BOJ_9020 {
    public static boolean[] prime = new boolean[10001]; // 2n + 1까지;


    //주의 사항
    //1. 2보다 큰 짝수가 주어질 때 소수의 합을 구해야함
    //2. 소수의 합이 여러개 일 경우 두 소수의 차가 적은 것으로 선별
    //3. 두 개의 소수 출력시 작은 소수부터
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        get_Prime();

        for(int i = 0 ; i < TC ; i++){
            int number = Integer.parseInt(br.readLine());
            int a = number/2;
            int b = number/2;
            // 두 소수의 차가 적은 것 부터 선별 -> 절반으로 나누어서 검사,
                        // 중앙 기준 a는 1씩 감소, b는 1씩 증가 해서 각 값이 소수인걸
                        // number는 짝수이므로 중앙 선별 쉬움
            while(true){
                if(!prime[a] && !prime[b]){
                    System.out.println(a + " " + b);
                    break;
                }
                a--;
                b++;
            }

        }
    }

    public static void get_Prime(){
        //소수가 아니면 true
        //소수면 false
        prime[0] = prime[1] = true;
        for(int i = 2 ; i < Math.sqrt(prime.length) ; i++){
            if(prime[i]) continue;

            for(int j = i * i ; j < prime.length ; j += i){
                prime[j] = true;
            }
        }
    }
}