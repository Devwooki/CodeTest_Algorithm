import java.io.*;
import java.util.*;

public class BOJ_2605_lineup{
    /*
    첫 번쨰 학생 무조건 0번 -> 맨앞
    두 번 째 0 or 1 (0은 제자리 1은 1칸 앞으로)
    세 번째 0 1 2 (0 제자리 1 1칸앞으로 2칸 앞으로)
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 1 ; i <= num; ++i){
            int a = Integer.parseInt(st.nextToken());
            list.add(i-a,i); //Array의 index 위치에 배열 삽입입
       }
        for(int i = 1 ; i <= num; ++i){
            sb.append(list.get(i)+ " ");
        }
        System.out.print(sb);
    }
}