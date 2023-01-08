import java.io.*;
import java.util.*;

public class BOJ_1744_bindingMax{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plus =   new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus =   new PriorityQueue<>();//음수는 우선순위 낮은거로
        int cnt1 = 0, cnt0 = 0;
        long sum = 0;
        for(int i = 0 ; i < N ; ++i){
            int x = Integer.parseInt(br.readLine());
            if(x < 0) minus.add(x);
            else if(x==1) cnt1++;
            else if(x==0) cnt0++;
            else if(x > 1) plus.add(x);
        }

        //양수 처리 - 큰 순서대로 2개씩 뽑아서 곱함, 1개 이하 남을 때 까지
        while(plus.size() > 1){
            int x = plus.poll();
            int y = plus.poll();
            sum += (x*y);
        }
        if(!plus.isEmpty()){//1개 남아있으면 ,  1과 곱하면 손해(1이 그냥 사라지므로)
            sum += plus.poll();
        }
        //음수 처리
        while(minus.size() > 1){
            int x = minus.poll();
            int y = minus.poll();
            sum += (x*y);
        }
        if(!minus.isEmpty() && cnt0 == 0)
            sum += minus.poll();


        sum += cnt1;

        System.out.print(sum);

    }
}
