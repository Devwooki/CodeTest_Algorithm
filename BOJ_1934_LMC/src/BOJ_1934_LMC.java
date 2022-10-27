import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1934_LMC {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < TC ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a =  Integer.parseInt(st.nextToken());
            int b =  Integer.parseInt(st.nextToken());

            sb.append(LMC(Math.max(a,b), Math.min(a,b))).append("\n");
        }
        System.out.println(sb);
    }

    public static int GCD(int a, int b){
        while( b > 0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
    public static int recursiveGCD(int a, int b){
        if(b==0) return a;
        return recursiveGCD(b,a%b);
    }
    public static int LMC(int a, int b){
        return a * b / GCD(a, b);
    }
}

