import java.io.*;
import java.util.*;

public class BOJ_2750_Bubblesort{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        int[] arr = new int[TC];
        for(int i = 0 ; i < TC ; i++){
            arr[i]= Integer.parseInt(br.readLine());
        }

        //버블 정렬
        for(int i = 0 ; i < arr.length-1 ; ++i){
            for(int j = arr.length - 1 ; j > 0 ; --j){
                if(arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < TC ; i++){
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    }
}