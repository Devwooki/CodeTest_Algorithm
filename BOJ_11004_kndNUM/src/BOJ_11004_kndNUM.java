import java.io.*;
import java.util.*;

public class BOJ_11004_kndNUM{
    /*
    수가 N개 주어짐, A를 오름차순 정렬 했을 때 K번쨰 수 구하기
    시간제한 2초, N은 5,000,000 이하 -> 선택, 삽입, 버블인 O(n^2)으론 택도 업음
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; ++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }





        System.out.print(sb);
    }
}
