import java.io.*;
import java.util.*;

public class BOJ_14501_readyResign{
    public static int N;
    public static int[] D;

    public static int[] D2;
    public static int[] T2;
    public static int[] P2;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        D = new int[(N+1)]; //(N+1): 연산을 쉽게하기 위해 날짜와 배열인덱스 맞춤, +1 : N+1일에 정산 받으므로
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        
        /*
        마지막 날  상담정보를 배열 마지막으로 보냄
        ->index : 근무 가능한 일수가 되게하기 위함
        ex) index == 1 : 1일짜리만 근무 가능
        index = 5 : 5일 이하만 가능
         */
        for(int i = N ; i > 0 ; --i){
            st =  new StringTokenizer(br.readLine()," ");
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
            T2[N-i] = Integer.parseInt(st.nextToken());
            P2[N-i] = Integer.parseInt(st.nextToken());
        }

        //D : 근무가능한 일수가 i일 때 최대비용
        /*
        D[1] = 마지막  날의 상담만 골라서 가져감
        D[N] = 첫 째날 ~ 마지막 날까지 상담을  골라서 최대값
        -> 마지막 근무 후 퇴사하기 때문에 근무 가능일수가 1임
         */
        for(int i = 1 ; i < D.length ;++i){
            if(T[i] > i){
                D[i] = D[i-1];
            }
            /*
            i날짜에 주어진 상담 업무를 할 수 있는 경우
            1.  이전에 상담x
            2.  상담 해서 번비용 + dp[근무 가능일수 - 해당 상담일자] 비교해 큰값이  D에 저장됨
            ->  dp[근무 가능일수 - 해당 상담일자]은 이전에 계산됨(메모이제이션)
             */
            else{
                D[i] = Math.max(D[i-1],  P[i] + D[i-T[i]]);
            }
        }
        System.out.print(D[N]);

    }

    //bottom up 다른 방식
    public static int dp(int day){
        if(day == N+1) return 0;
        if(day >  N+1) return -1; //day가 N보다 크면 의미 없는 값이기  때문에
        if(D2[day] > 0) return D2[day]; //상담한 기록이 있다면 그냥 반환

        return D2[day] = Math.max(dp(day+1),  dp(day+T2[day] +P2[day]) );

    }
}