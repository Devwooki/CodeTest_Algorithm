import java.io.*;
import java.util.*;

public class BOJ_11399_ATMwithdraw{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sum = new int[N];
        int[] p = new int[N];
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        //p를 정렬해서 구간 누적합 더하기
        for(int i = 0 ; i < N ; ++i){
            p[i] = Integer.parseInt(st.nextToken());
        }

        //선택 정렬 구현
        for(int i = 1 ; i < N ; ++i){
            int key = p[i];
            int inputIDX = 0;
            for(int j = i-1 ; j >= 0 ; --j){
                if(p[j] > key){ //옆으로 한칸씩 밀어냄
                    p[j+1] = p[j];
                    inputIDX++;
                }
            }
            p[i-inputIDX] =  key;
        }
        //누적합 배열 구하기
        sum[0] = p[0];
        for(int i = 1 ; i < N ; ++i){
            sum[i] = sum[i-1] + p[i];
        }

        //누적합 배열의 누적
        for(int i = 0 ; i < N ; ++i){
            result += sum[i];
        }
        System.out.print(result);

    }

    public static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }
}
