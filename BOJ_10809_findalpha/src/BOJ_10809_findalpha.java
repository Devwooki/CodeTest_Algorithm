import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10809_findalpha {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int arrlen = 26;
        int[] arr = new int[arrlen];
        Arrays.fill(arr,  -1); // 배열 특정 값으로  초기화

        for(int i = 0 ; i <  str.length() ; i++){
            char c = str.charAt(i);
            arr[c-'a'] = str.indexOf(c);
        }

        for(int i = 0 ; i <  arrlen ; i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);

    }
}
