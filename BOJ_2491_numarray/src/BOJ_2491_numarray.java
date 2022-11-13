import java.io.*;
import java.util.*;

public class BOJ_2491_numarray{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[num];
        for(int i = 0 ; i < num ; ++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //오름차순
        int inc_cnt =  1;
        int max = 1; //최대로 연속되는 수열의 길이를 저장해야하므로 max  지정

        for(int i = 1 ; i < num ; ++i){
            if(arr[i-1] <=  arr[i]) inc_cnt++;
            else inc_cnt=1;
            max = Math.max(max, inc_cnt);
        }
        //내림차순 확인
        int dsc_cnt =  1;
        for(int i = 1 ; i < num ; ++i){
            if(arr[i-1] >=  arr[i]) dsc_cnt++;
            else dsc_cnt = 1;
            max = Math.max(max, dsc_cnt);

        }

        System.out.print(max);
    }
}