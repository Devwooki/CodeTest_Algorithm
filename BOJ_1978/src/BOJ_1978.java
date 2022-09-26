import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_1978 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int cnt = 0;

        while(st.hasMoreTokens()){
            int a = Integer.parseInt(st.nextToken());
            if(check_sosu(a))
                cnt++;
        }
        System.out.println(cnt);
    }

    public static boolean check_sosu(int num){
        //소수면 true, 아니면 false
        if(num == 1)
            return false;
        for(int i = 2 ; i <= Math.sqrt(num) ; i++ ){ //약수가 홀수일 경우 대비해 = 삽입
            if(num % i == 0)
                return  false;
        }
        return true;
    }
}