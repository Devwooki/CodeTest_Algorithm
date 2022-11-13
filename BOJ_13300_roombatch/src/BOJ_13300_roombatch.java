import java.io.*;
import java.util.*;

public class BOJ_13300_roombatch{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());  // 수학여행 참가 인원
        int K = Integer.parseInt(st.nextToken());  // 방 최대 수용인원
        int[][] student = new int[7][2];
        for(int i = 0 ; i < N ; ++i){
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken()); // 0 : 여학생, 1 남학생생
            int Y = Integer.parseInt(st.nextToken()); //학년 1 ~ 6
            student[Y][S]++;
        }
        int room = 0;
        for(int i = 1 ; i <= 6 ; ++i){ //1학년 부터 6학년
            for(int j = 0 ; j < 2 ; ++j){ //여학생과 남학생
                if(student[i][j] > 0 && student[i][j] <= K ) room++; // 0 < 학생수 <= K - 방 1개
                else if(student[i][j] == 0 ) continue; // 학생수 0 -> 방 필요없음 continue
                else if(student[i][j] > K){ // 학생 수 K 보다 클 때
                    if(student[i][j] % K == 0) room += student[i][j]/K;
                    else room +=student[i][j]/K +1;
                }
            }
        }
        System.out.print(room);

    }
}