import java.io.*;
import java.util.*;

public class BOJ_11399_ATMwithdraw{
    //줄서는 순서가 Pi작은 순으로 서야 최솟값으로 출력
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sum = new int[N];
        int[] p = new int[N];
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        //p를 정렬해서 구간 누적합 더하기

        //
        for(int i = 0 ; i < N ; ++i){
            p[i] = Integer.parseInt(st.nextToken());
        }

        //선택 정렬 구현
//        for(int i = 1 ; i < N ; ++i){
//            int key = p[i];
//            int inputIDX = 0;
//            for(int j = i-1 ; j >= 0 ; --j){
//                if(p[j] > key){ //옆으로 한칸씩 밀어냄
//                    p[j+1] = p[j];
//                    inputIDX++;
//                }
//            }
//            p[i-inputIDX] =  key;
//        }

        for(int i = 1 ; i < N ; ++i){
            int key = p[i];
            int j = i - 1;
            while(j >=  0  && key < p[j]){
                p[j+1] = p[j];
                j--;
            }
            /*
            반복문을 탈출하게 되면 앞 원소보다 타겟이 작다는 의미
            -> 타겟원소는 J번째 뒤에 와야함
             */
            p[j+1] =  key;
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
