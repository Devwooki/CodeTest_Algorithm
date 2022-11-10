import java.io.*;
import java.util.*;

public class BOJ_1427_selectSort{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        int[] arr = new int[N.length()];
        for(int i = 0 ; i < N.length() ; ++i){
            arr[i] = Integer.parseInt(N.substring(i, i+1));
        }

        for(int i = 0 ; i < N.length() ; ++i){
            int max = i;
            for(int j = i+1 ; j < N.length() ; ++j) {
                if(arr[j] > arr[max])
                    max = j;
            }
            if(arr[i] <  arr[max]){
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] =  temp;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N.length() ; i++){
            sb.append(arr[i]);
        }
        System.out.print(sb);

    }
}