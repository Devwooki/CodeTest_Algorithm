import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_4948 {
    public static boolean[] prime = new boolean[246913]; // 2n + 1까지;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int num = Integer.parseInt(br.readLine());
            if(num == 0 ) break;

            int cnt = 0;
            prime();

            for(int i = num+1 ; i<= 2*num ; i++){
                if(!prime[i])  cnt++;
            }
            System.out.println(cnt);
        }
    }

    public static void prime(){
        prime[0] = prime[1] = true;
        for(int i = 2 ; i < Math.sqrt(prime.length); i++){
            if(prime[i]) continue; // 이미 걸러진 배열 : 값이 true인 배열은 스킵

            for(int j = i * i ; j < prime.length ; j +=i){
                prime[j] =  true;
            }
        }

    }
}