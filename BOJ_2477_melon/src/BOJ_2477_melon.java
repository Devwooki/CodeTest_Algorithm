import java.io.*;
import java.util.*;

public class BOJ_2477_melon{
    //1동, 2서, 3남, 4북
    //6각형이기에 단차가 1개만 존재 -> 단차를 어떻게 구하나
    //  -> -> <-- or -->  <- <- || 세로로 이와 마찬가지
    // row_max
    // 가로이동 후엔 무조건 세로 이동이 나옴 -> 반대로 세로 이동 후엔 무조건 가로 나옴
    //
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] dir = new int[6]; //방향 저장
        int[] len = new int[6]; //길이 저장
        int max_w = 0;
        int max_h = 0;
        int max_w_idx = 0; // w가 홀수 인덱스 -> h짝수 인덱스
        int max_h_idx = 0; // h가 홀수 인덱스 -> w짝수 인덱스
        int K = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < 6 ; ++i){
            st = new StringTokenizer(br.readLine()," ");
            dir[i] = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());
            if(dir[i] == 1 || dir[i] == 2) {
                if(max_w < len[i]) max_w_idx = i;
                max_w = Math.max(max_w, len[i]);

            }
            else if(dir[i] == 3 || dir[i] == 4){
                if(max_h < len[i]) max_h_idx = i;
                max_h = Math.max(max_h, len[i]);
            }
        }
        int fullSpace = max_h * max_w;
        //max는 맨앞, 맨 마지막에 등장 할 수 있음
        //맨 앞에 등장 -> h는 첫뻔째 , w는 2번째꺼 사용하는게 emptySpace
        //max가 맨 뒤에 등장
        //h는 2번째, w는  첫번째꺼 사용하는게 emptySpace
        // A - B - C - D- E- F가 있으면
        // ab가 최대 -> de 곱하면 되고
        // ef 최대면 -> bc 곱하면 됨 -> ab인덱스에서 +3해주면 댐
        int emptySpace = len[(max_w_idx+3)%6] * len[(max_h_idx+3)%6];

        System.out.print(K*(fullSpace-emptySpace));

    }
}
