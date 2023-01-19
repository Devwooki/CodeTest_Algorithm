import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st =  new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] map = new  int[N][M];
        System.out.print(sb);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < N ; ++i){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M; ++j){
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        //땅파서 인벤에 넣으면 2초
        //인벤에서 채우면 1초
        int prev = Integer.MAX_VALUE; //최소 시간을 골라야함
        int hieght = 0;
        for(int i = min ; i <= max ; ++i){
            int time = 0;
            int block = B;
            for(int j = 0 ; j < N ; ++j){
                for(int k = 0 ; k < M ; ++k){
                    //최솟값 기준으로 맞추기
                    if(i<map[j][k]){//현재높이가 i보다 크면 땅을 파야함
                        block +=  (map[j][k] - i);
                        time += ((map[j][k] - i)  *2);
                    }else{ //같거나 i보다 낮으면 채워야함
                        block -= (i-map[j][k]);
                        time += (i-map[j][k]);
                    }
                }
            }
            if(block <0 ) break; //블록 없으면 종료
            if(prev >= time ){//작업시간이  prev보다 작으면 prev저장, 시간이 같으면 높이가 높은 것을 출력해야하니  같을 때도 포함
                prev = time;
                hieght = i;
            }
        }
        System.out.println(prev + " " +  hieght);
        //땅을 고르는 시간과 땅 높이  출력, 답이 여러개면 땅 높이가 가장 높은 것
    }
}