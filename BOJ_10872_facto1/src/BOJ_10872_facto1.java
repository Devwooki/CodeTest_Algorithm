import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10872_facto1 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        System.out.println(myFacto(num));

    }

    public static long myFacto(int n){
        if(n == 0 || n == 1) return 1;
        return n*myFacto(n-1);
    }
}