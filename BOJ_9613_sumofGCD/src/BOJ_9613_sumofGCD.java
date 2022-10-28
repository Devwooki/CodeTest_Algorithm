import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_9613_sumofGCD {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st;
        int TC = Integer.parseInt(br.readLine());
        long sum;
        int[] arr;

        for(int i = 0 ; i < TC ; i++){
            st = new StringTokenizer(br.readLine());
            sum = 0;
            int num = Integer.parseInt(st.nextToken());
            arr = new int[num];
            for(int j = 0 ; j < num ; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            for(int j = 0 ; j < num-1 ; j++){
                for(int k = j+1 ; k < num ; k++){
                    sum += GCD(arr[j], arr[k]);
                }
            }
            System.out.println(sum);

        }
    }

    //매개변수 a > b 무조건
    public static int GCD(int b, int a){
        while(b>0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}

