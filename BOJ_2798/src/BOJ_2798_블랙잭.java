import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2798_블랙잭 {
    //블랙잭
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken()); // 수의 갯수
        int blackJack = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) arr[i] = Integer.parseInt(st.nextToken());

        System.out.println(getMySum(arr, num, blackJack));


    }

    public static int getMySum(int[] arr, int N, int bj){
        int nowSum = 0;
        int prevSum = 0;

        for(int i = 0 ; i < N -2 ; i++){
            for(int j = i + 1 ; j < N-1 ; j++){
                for(int k = j + 1 ; k < N ; k++){
                    nowSum = arr[i] + arr[j] + arr[k];

                    //숫자합이 블랙잭과 같으면 리턴턴
                    if(bj == nowSum){
                        return nowSum;
                    }

                   //숫자합이 블랙잭보다 작고, 이전 합보다 크면
                    if(prevSum < nowSum  && nowSum < bj)
                        prevSum = nowSum;
                }
            }
        }
        return prevSum;
    }


    //첫번째, 두 번째 카드의 합이 blackjack을 넘어가면 의미 없어지므로
    public static int getMySum2(int[] arr, int N, int bj){
        int nowSum = 0;
        int prevSum = 0;

        for(int i = 0 ; i < N -2 ; i++){
            for(int j = i + 1 ; j < N-1 ; j++){
                if(arr[i] + arr[j] > bj) continue;

                for(int k = j + 1 ; k < N ; k++){
                    nowSum = arr[i] + arr[j] + arr[k];

                    //숫자합이 블랙잭과 같으면 리턴턴
                    if(bj == nowSum){
                        return nowSum;
                    }

                    //숫자합이 블랙잭보다 작고, 이전 합보다 크면
                    if(prevSum < nowSum  && nowSum < bj)
                        prevSum = nowSum;
                }
            }
        }
        return prevSum;
    }
}