import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BOJ_6588_goldhach_1 {
    public static boolean[] prime = new boolean[1000001]; // 2n + 1까지;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        getPrime();
        int num;
        boolean isProve = false;
        do{
            num = Integer.parseInt(br.readLine());
            if(num == 0) break;
            //b-a 차가 적은 것 -> num/2 해서  +1, -1연산 처음나온 것
            //b-a 차가 큰 것 -> 0, num에서 부터 +1, -1연산 처음 나온 것
            for(int i = 2 ; i < num/2 ; i++ ){
                if(!prime[i] && !prime[num-i]){
                    sb.append(num).append(" = ").append(i).append(" + ").append(num-i).append("\n");
                    isProve = true;
                    break;
                }

            }
            if(!isProve)
                sb.append("Goldbach's conjecture is wrong.");
        }while(true);


        System.out.print(sb);
    }

    public static void getPrime(){
        //소수 0과 1은
        prime[0] =  prime[1] = true;
        for(int i = 2 ; i < Math.sqrt(prime.length) ; i++){// 2,,,3,,,4,,
            if(prime[i]) continue; //i가 true => 소수이면 continue
            for(int j = i * i ; j < prime.length ; j += i ){ //2의배수, 3의배수,, 4의 배수,,
                prime[j] = true; //i의 배수면 소수가 아니므로  false
            }
        }
    }
}
