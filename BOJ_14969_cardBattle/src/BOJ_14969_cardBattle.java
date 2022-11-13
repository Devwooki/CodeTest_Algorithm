import java.io.*;
import java.util.*;

/*
만약 두 딱지의 별의 개수가 다르다면, 별이 많은 쪽의 딱지가 이긴다.
별의 개수가 같고 동그라미의 개수가 다르다면, 동그라미가 많은 쪽의 딱지가 이긴다.
별, 동그라미의 개수가 각각 같고 네모의 개수가 다르다면, 네모가 많은 쪽의 딱지가 이긴다.
별, 동그라미, 네모의 개수가 각각 같고 세모의 개수가 다르다면, 세모가 많은 쪽의 딱지가 이긴다.
별, 동그라미, 네모, 세모의 개수가 각각 모두 같다면 무승부이다.

별 > 동> 네 > 세 많은 순서
4 > 3 > 2 > 1로 표현
 */
public class BOJ_14969_cardBattle{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stA;
        StringTokenizer stB;
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[5];
        int[] B = new int[5];
        for(int i = 1 ; i <= N ; ++i){
            //라운드 마다 A와 B의 딱지 종류별 갯수 배열에 저장
            //매 라운드 마다 배열 초기화
            Arrays.fill(A, 0);
            Arrays.fill(B, 0);
            //A딱지
            stA = new StringTokenizer(br.readLine()," ");
            int a_num = Integer.parseInt(stA.nextToken());
            for(int j = 0 ; j <  a_num; ++j){
                int a_DDAK = Integer.parseInt(stA.nextToken());
                A[a_DDAK]++;
            }
            //B딱지
            stB = new StringTokenizer(br.readLine()," ");
            int b_num = Integer.parseInt(stB.nextToken());
            for(int j = 0 ; j <  b_num; ++j){
                int b_DDAK = Integer.parseInt(stB.nextToken());
                B[b_DDAK]++;
            }

            int same=0;
            for(int j = 4 ; j >= 1 ; --j){
                if(A[j] > B[j]){    //A가 더 크면  승자 출력 후 해당 라운드 종료
                    sb.append("A\n");
                    break;
                }
                else if(A[j] < B[j]){ //B가 더 크면  승자 출력 후 해당 라운드 종료
                    sb.append("B\n");
                    break;
                }else {                //같으면  same 증가시켜부러
                    same++;
                    continue;
                }
            }
            if(same == 4) sb.append("D\n");
        }
        System.out.print(sb);

    }
}