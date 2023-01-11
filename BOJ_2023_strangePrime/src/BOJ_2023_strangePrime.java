import java.io.*;
import java.util.*;

public class BOJ_2023_strangePrime{

    public static boolean[] primeFilter;
    public static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        primeFilter = new boolean[100000001];
//        createPrime();
        System.out.print(sb);
        //첫번째 숫자는 2,3,5,7만 가능
        //두 번째 숫자는 1,3,5,7,9중 첫번째 숫자와 결합하여  소수가  아닌 것들로
        DFS(2, 1,sb);
        DFS(3, 1,sb);
        DFS(5, 1,sb);
        DFS(7, 1,sb);

        System.out.println(sb);
    }

    //@param num : 숫자
    //@param a : 자릿수
    public static void DFS(int num, int a, StringBuilder sb){
        if(a==N){//자릿수가 N이고
            if(isPrime(num))//num이 소수면
                //System.out.println(num); //출력하고
                sb.append(num + "\n");
            return; //종료
        }
        //아니면 1,3,5,7,9넣으면서
        for(int i = 1; i < 10 ; i+=2){
            if(isPrime(num*10 + i)) DFS(num*10 + i, a+1, sb);//자릿 수 늘림
        }
    }


    //에라토스테네스의 체를 사용하니 매모리 초과(배열의 길이가 1억개니까)
//    public static void createPrime(){
//        /*
//        ture : 소수 아님
//        false : 소수임
//         */
//        primeFilter[0] = primeFilter[1] = true;
//        for(int i = 2 ; i < Math.sqrt(primeFilter.length) ; ++i){
//            if(!primeFilter[i]){//i가 소수라면 j들은 소수가 아님
//                for(int j = i*i ; j <Math.sqrt(primeFilter.length) ; j+=i){
//                    primeFilter[j] =  true;
//                }
//            }
//        }
//    }
    public static boolean isPrime(int num){
        for(int i = 2 ; i <= num/2 ; ++i){
            if(num%i == 0) return false;
        }
        return true;
    }
}