import java.io.*;
import java.util.*;

public class BOJ_10157_setSit{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        int[][] sit = new int[R+1][C+1];
        int x = 1;
        int y  = 1;
        int dir = 0;

        if(K > C*R || K < 1){
            sb.append(0);
            System.out.println(sb);
            return;
        }
        int a = 1;
        while(true) {
            if(a>K){
                break;
            }
            sit[y][x] = a;
            //다음 위치 이동
            x += dx[dir];
            y += dy[dir];

            //다음위치가 벽을만나거나 숫자가 0외의 숫자면
            if( x > C || x < 1 || y > R || y < 1 || sit[y][x] != 0){
                x -= dx[dir]; //갔던 방향 되돌아와서
                y -= dy[dir];
                dir = (dir+1)%4; //방향틀고
                x += dx[dir]; //다시가기
                y += dy[dir];
            }
            a++;
        }
//        for(int i = 0 ; i < R+1; ++i){
//            for(int j =  0; j < C+1; ++j){
//                System.out.print(sit[i][j] + "\t");
//            }
//            System.out.println();
//        }
        //이동 전의 좌표를 출력
        sb.append((x - dx[dir]) + " " + (y - dy[dir]));
        System.out.print(sb);

    }
}
