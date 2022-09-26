import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Scanner;

public class BOJ_10250 {
    public static void main(String[] args) throws IOException{
        //Scanner는 입력 데이터를 자료형에 맞추느라 느려짐
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        Scanner sc = new Scanner(System.in);


        int TC = sc.nextInt();

        for(int i = 0 ; i < TC ; i++){
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();
            sc.nextInt();
            //층수 N / H 의 나머지 ->
            //호수 N / H 몫 + 1, N%W = 0 ->
            if(N % H == 0)
                System.out.println( (H* 100) + (N/H));
            else
                System.out.println( (N%H* 100) + (N/H) + 1);
        }

    }
}