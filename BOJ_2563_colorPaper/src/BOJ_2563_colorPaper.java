import java.io.*;
import java.util.*;

public class BOJ_2563_colorPaper{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        boolean[][] map = new boolean[100][100];
        int TC = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < TC ; ++i){
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            for(int y = B ; y < B+10 ; ++y){
                for(int x = A ; x < A+10 ; ++x){
                    map[y][x] = true;
                }
            }
        }
        int cnt =0;
        for(int y = 0 ; y < 100 ; ++y){
            for(int x = 0 ; x < 100 ; ++x){
                if(map[y][x]) cnt++;
            }
        }

        System.out.print(cnt);

    }
}
