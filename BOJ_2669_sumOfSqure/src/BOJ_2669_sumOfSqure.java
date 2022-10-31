import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2669_sumOfSqure {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean[][] field = new boolean[100][100];
        int cnt =0;
        for(int i = 0 ; i < 4; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = y1-1 ; j < y2-1; j++){
                for(int k = x1-1 ; k < x2-1; k++){
                    field[j][k] = true;
                }
            }
        }

        for(int i = 0 ; i < field.length ; i++){
            for(int j = 0 ; j <field[i].length ; j++){
                if(field[i][j]) cnt++;
            }
        }
        System.out.print(cnt);

    }
}