import java.io.*;
import java.util.*;

public class BOJ_10163_colorpaper{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[][] map = new int[1001][1001];
        int N = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= N ; ++i){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int addA = Integer.parseInt(st.nextToken());
            int addB = Integer.parseInt(st.nextToken());

            for(int y = b ; y < (b+ addB) ; ++y){
                for(int x = a ; x < (a+addA) ; ++x){
                    map[y][x] = i;
                }
            }
        }

        for(int i = 1; i <= N ; ++i){
            int cnt = 0;
            for(int y = 0 ; y < 1001 ; ++y){
                for(int x = 0 ; x < 1001 ; ++x){
                    if(map[y][x] == i) cnt++;
                }
            }
            sb.append(cnt + "\n");

        }
        System.out.print(sb);

    }
}