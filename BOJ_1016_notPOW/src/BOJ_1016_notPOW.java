import java.io.*;
import java.util.*;

public class BOJ_1016_notPOW{
    public static boolean checks[];
    public static long min, max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        min = Long.parseLong(st.nextToken());
        max = Long.parseLong(st.nextToken());
        isPow();
        //1보다 큰 제곱수로 나누어 떨어지지 않을 때  제곱이 아닌 수라 함

        long cnt = 0;
        for(int i = 0 ; i < checks.length ; ++i)
            if(!checks[i]) cnt++;

        System.out.println(cnt);
    }

    public static void isPow(){
        //가장 작은 제곱수는 4 = 2^2
        checks = new boolean[(int) (max -  min +1)];
        /*
        min = 1,000,000,000,000, max = 1,000,000,500,000 -> 실제 차이는 50만
        배열 A[i] = i + min으로 계산,
        예를 들어 min = 1, max = 120일경우
        10^2 < max < 11^2이므로
         2^2 <= x <= sqrt(max)이다

         */
        for(long i = 2 ; i <= Math.sqrt(max); ++i){ //제곱수의 제곱근 -> i^2가 max이하일 때 까지 반복
            long pow = i * i;
            long start = min%pow == 0 ?  min/pow : (min/pow)+1;//제곱수의 배수를 구하는 인덱서
            //에라토스테네스 체와 달리 시작값이 1이 아닐경우
            /*
            i = 2, 구간이 10~20일 경우, i^2 = 이므로 4의 배수를 제거 해야하지만 시작인덱스가 1이 아니므로 10이하인 4, 8을 제거 못하고
            불필요한 연사을 하게 됨 -> 구간 시작에 따라 곱셈 인덱스  j를 계산행햐ㅏㅁ

            i = 2, i^2 =4이고 구간 시작이 10이면 10이하 자연수 중 4*1, 4*2는 건너뛰므로 i=3부터 시작해야함
             */
            for(long j = start ; j * pow <=  max ; j++) {
                checks[(int) ((j * pow) - min)]=true;
            }

       }

    }
}
