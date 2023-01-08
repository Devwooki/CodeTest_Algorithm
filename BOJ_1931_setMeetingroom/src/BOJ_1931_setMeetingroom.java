import java.io.*;
import java.util.*;

public class BOJ_1931_setMeetingroom{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] info =  new int[N][2];
        StringTokenizer st;
        for(int i = 0 ; i < N ; ++i){
            st = new StringTokenizer(br.readLine()," ");
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }
        //종료시간이 빨리 끝나는대로 정렬
        //
        Arrays.sort(info, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){ //종료시간 같으면  시작시간순서
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1]; //종료 시간 오름차순 정렬
            }
        });



        int cnt = 1;
        int start = info[0][0];
        int end = info[0][1];
        for(int i = 1 ; i < N ; ++i){
            if(end > info[i][0]){
                continue;
            }else{
                cnt++;
                start = info[i][0];
                end = info[i][1];
            }

        }

        System.out.print(sb);

    }
}