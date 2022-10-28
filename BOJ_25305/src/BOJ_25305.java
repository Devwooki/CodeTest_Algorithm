import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Arrays;


public class BOJ_25305 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int breakPoint = Integer.parseInt(st.nextToken())-1;

        Integer[] arr = new Integer[num];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < num ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());

        System.out.println(arr[breakPoint]);

    }
}