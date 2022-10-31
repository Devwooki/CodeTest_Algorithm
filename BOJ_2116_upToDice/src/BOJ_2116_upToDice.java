import java.io.*;
import java.util.*;

// 서로 붙어있는 두 주사위의 숫자가 같아야함.
// 주사위를 TC만큼 쌓았을 때 정면, 90도, 180도, 270도 중에 가장 큰 값을 가지도록 주사위를 쌓고자 할 때
/*
    A
 B  C  D  E
    F  < 주사위 전개도
 */
public class BOJ_2116_upToDice {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        int[][] dice = new int[TC][6];
        for(int i = 0 ; i < TC ; ++i){
            st = new StringTokenizer(br.readLine());
            dice[i][0] = Integer.parseInt(st.nextToken());
            dice[i][1] = Integer.parseInt(st.nextToken());
            dice[i][2] = Integer.parseInt(st.nextToken());
            dice[i][3] = Integer.parseInt(st.nextToken());
            dice[i][4] = Integer.parseInt(st.nextToken());
            dice[i][5] = Integer.parseInt(st.nextToken());
        }//주사위는 (0,5),(1,3), (2,4)가  한 쌍이다.

        int maxSum = 0;
        for(int i = 0 ; i < 6 ; ++i){ //아래 다이스의 6개면
            int bottom = dice[0][i];
            int top  = dice[0][getPair(i)];
            int side = sideMax(bottom, top);
            for(int j = 1 ; j < TC ; ++j){// 위에 있는 다이스 갯수만큼
                for(int k = 0 ; k < 6 ; ++k ){ //위에 있는 다이스에서 bottom, top찾기
                    if(dice[j][k] == top){
                        bottom = dice[j][k];
                        top = dice[j][getPair(k)];
                        break;
                    }
                }
                side += sideMax(bottom,top);
            }
            maxSum = Math.max(maxSum, side);
        }

        System.out.println(maxSum);
    }

    public static int getPair(int a){
        int pair = 0;
        switch(a){
            case 0 : pair = 5; break;
            case 1 : pair = 3; break;
            case 2 : pair = 4; break;
            case 3 : pair = 1; break;
            case 4 : pair = 2; break;
            //5의 경우 0을return 하지만 초기화 값과 같으므로 그냥 둠
        }
        return pair;
    }

    public static int sideMax(int bottom, int top){
        // bottom, top이 5,6 or 6,5일 경우 side 가장 큰 값은 4
        if(bottom + top == 11){
            return 4;
        }else if(bottom == 6 || top == 6){//bottom이나 top이 6이고 나머지 5미만
            return 5;
        }else return 6;
    }
}