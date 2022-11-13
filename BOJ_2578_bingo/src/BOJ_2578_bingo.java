import java.io.*;
import java.util.*;

public class BOJ_2578_bingo{
    public static int[][] board;
    static int bingoCnt = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        board = new int[5][5];
        int called[] = new int[26];
        StringTokenizer st;

        //빙고판  초기화
        for(int i = 0 ; i < 5 ; ++i){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < 5 ; ++j){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < 5 ; ++i){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= 5 ; ++j){
                called[i*5+j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1 ; i <= 25 ; ++i){
                int call = called[i];
                //빙고판에 찾아서 -1로 바꿈
                findCall(call);
                //빙고 탐색
                Width();
                Height();
                L();
                R();
                if(bingoCnt>= 3) {
                    System.out.println(i);
                    return;
                }
                bingoCnt = 0;
            }


        //사회자 부른 숫자
//        for(int i = 0 ; i < 5 ; ++i){
//            st = new StringTokenizer(br.readLine());
//            for(int j = 1 ; j <= 5 ; ++j){
//                int call = Integer.parseInt(st.nextToken());
//                //빙고판에 찾아서 -1로 바꿈
//                findCall(call);
//                //빙고 탐색
//                Width();
//                Height();
//                L();
//                R();
//                int a = i*5 +j;
//                if(bingoCnt>= 3) {
//                    System.out.println(a);
//                    return;
//                }
//            }
//        }
    }

    //사회자가 불러준 값  -1로바꿈
    public static void findCall(int c){
        for(int k = 0 ; k < 5 ; ++k){
            for(int l = 0 ; l < 5 ; ++l){
                if(c == board[k][l]){
                    board[k][l] = -1;
                }
            }
        }
    }
    //행체크
    public static void Width(){
        for(int k = 0 ; k < 5 ; ++k){
            int cnt = 0;
            for(int l = 0 ; l < 5 ; ++l){
                if(board[k][l] == -1) cnt++;
            }
            if(cnt == 5) bingoCnt++;
        }
    }
    //열체크
    public static void Height(){
        for(int k = 0 ; k < 5 ; ++k){
            int cnt = 0;
            for(int l = 0 ; l < 5 ; ++l){
                if(board[l][k] == -1) cnt++;
            }
            if(cnt == 5) bingoCnt++;
        }
    }
    public static void L(){
        int cnt = 0;
        for(int k = 0 ; k < 5 ; ++k){
            if(board[k][4-k] == -1) cnt++;
        }
        if(cnt==5) bingoCnt++;
    }
    public static void R() {
        int cnt = 0;
        for (int k = 0; k < 5; ++k) {
            if (board[k][k] == -1) cnt++;
        }
        if(cnt==5) bingoCnt++;
    }
}