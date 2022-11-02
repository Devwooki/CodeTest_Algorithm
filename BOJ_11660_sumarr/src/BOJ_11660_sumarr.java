import java.io.*;
import java.util.*;

public class BOJ_11660_sumarr{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int TC = Integer.parseInt(st.nextToken());

        //배열 저장
        int[][] arr = new int[num+1][num+1];
        for(int i = 1 ; i <= num ; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= num ; ++j){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //누적합 배열 생성
        int[][] s = new int[num+1][num+1];
        for(int i = 1 ; i <= num ; ++i){
            for(int j = 1 ; j <= num ; ++j){
                s[i][j] = s[i-1][j] + s[i][j-1] - s[i-1][j-1]  + arr[i][j];
            }
        }

        for(int i = 0 ; i < TC ; ++i){
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = s[x2][y2] - s[x1-1][y2] - s[x2][y1-1] + s[x1-1][y1-1];
            System.out.println(result);
        }
    }
}