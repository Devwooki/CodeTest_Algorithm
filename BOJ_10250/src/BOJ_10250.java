import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class BOJ_10250 {
    public static void main(String[] args) throws IOException{
        //Scanner는 입력 데이터를 자료형에 맞추느라 느려짐
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int TC = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < TC ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            //층수 N / H 의 나머지 ->
            //호수 N / H 몫 + 1, N%W = 0 ->
            if(N % H == 0)
                System.out.println( (H* 100) + (N/H));
            else
                System.out.println( (N%H* 100) + (N/H) + 1);
        }

    }
}