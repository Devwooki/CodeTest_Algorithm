import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        //손익분기점 계산 :간단식
        //A : 고정비용, B : 생산단가, C : 제품 가격, N : 제품 판매 수
        Scanner in = new Scanner(System.in);

        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();

        System.out.println(calcul(A,B,C));
    }

    public static int calcul(int a, int b, int c){
        // A/(C-B) < N
        if(c-b < 0)
            return -1;
        else{
            return a/(c-b)+1;
        }
    }
}
