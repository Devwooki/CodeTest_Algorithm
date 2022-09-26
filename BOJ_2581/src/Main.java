import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int lowValue = Integer.parseInt(br.readLine());
        int highValue = Integer.parseInt(br.readLine());

        int sum = 0;
        int minValue  = 10000;
        for(int i = lowValue ; i <= highValue ; i++){
            if (check_sosu(i)){
                sum += i;
                if(minValue > i)
                    minValue = i;
            };
        }
        if(sum == 0)
            System.out.println(-1);
        else{
            System.out.println(sum);
            System.out.println(minValue);
        }

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