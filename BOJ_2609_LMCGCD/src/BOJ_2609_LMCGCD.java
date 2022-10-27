import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2609_LMCGCD {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb =  new StringBuilder();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        sb.append(GCD(Math.max(A,B),Math.min(A,B))).append(" ").append(LMC(Math.max(A,B),Math.min(A,B)));
        //두 숫자 중 큰 값의 제곱근까지 수행


        System.out.println(sb);
    }
    //최대 공약수
    public static int GCD(int a, int b){
        //유클리드 호제법 -> a>b에서 a%b==0 -> GCD,
        //                        a%b!=0 -> GCD a=b, b=r(r = a%b)로 다시 나누기
        while(b>0){
            int r = a%b;
            a = b;
            b =r;
        }
        return a;
    }
    //최소 공배수
    public static int LMC(int a, int b){
        return a * b /GCD(a,b);
    }
}

