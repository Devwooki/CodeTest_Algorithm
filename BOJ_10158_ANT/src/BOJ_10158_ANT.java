import java.io.*;
import java.util.*;

public class BOJ_10158_ANT{
    public static void main(String[] args) throws IOException{
        //오른쪽 위 45도 방향
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(br.readLine());

        /* <가로기준 설명>
        개미는 짜피 W내에서만 움직임, 만약 P = 0, W=4, T=8일경우
        P는 W끝까지 갔다가 남은 값만큼 돌아옴 -> Math.abs(W-(P+T)%(2*W));
         */
        int x = W - Math.abs(W - (p + time) % (W * 2));
        int y = H - Math.abs(H - (q + time) % (H * 2));

        sb.append(x + " " + y);
        System.out.print(sb);

    }
}

/*      방법 1 시간초과

        개미는 첫시작 오른쪽 45도 (+1, +1)방향
        개미 x좌표가 W-1을 만나면 방향 -1 | 0을만나면+1
        개미 y좌표가 H-1을 만나면 -1 | 0을만나면 +1
        int dx = 1;
        int dy = 1;
        while(time > 0){
                //다음 위치로 이동
                nowX += dx;
                nowY += dy;
                time--;
                //이동
                if(nowX > W){
                nowX -= dx;
                dx = -1;
                nowX += dx;
                }else if(nowX < 0){
        nowX -= dx;
        dx = 1;
        nowX += dx;
        }

        if(nowY > H){
        nowY -= dy;
        dy = -1;
        nowY += dy;
        }else if(nowY < 0){
        nowY -= dy;
        dy = 1;
        nowY += dy;
        }
        }
 */
