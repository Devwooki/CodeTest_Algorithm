import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2869 {
    public static void main(String[] args) throws IOException {
        /*
        정상 도착시 미끄러 지지 않음 -> 최종목표는 v-a
        걸리는 시간:dayV = (v-a)/(a-b)
        (v-a)/(a-b) % = 0 -> 오른 날짜 구함
        (v-a)/(a-b) % =/= 0 -> 하루 더 가야함 고로 +1
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int day = (v-a)/(a-b)+1;

        if((v-a)%(a-b) != 0)
            day++;

        System.out.println(day);
        br.close();
    }
}

        /* 반복문으 사용해 풀이 가능, 하지만 시간초과 발생 다른 방법으로 찾기
        int dayV = a-b;
        int count = 1;
        while(true){
            count++;
            if(dayV*(count-1)+a >= v)
                break;
        }
        */