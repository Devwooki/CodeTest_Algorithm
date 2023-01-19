import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for(int i = 0 ; i < TC ; i++){
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();
            //층수 N / H 의 나머지 ->
            //호수 N / H 몫 + 1, N%W = 0 ->
            if(N % H == 0)
                System.out.println( (H* 100) + (N/H));
            else
                System.out.println( (N%H* 100) + (N/H) + 1);
        }

    }
}