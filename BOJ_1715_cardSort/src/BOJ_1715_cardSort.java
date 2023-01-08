import java.io.*;
import java.util.*;

public class BOJ_1715_cardSort{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N =  Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < N ; ++i){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        while(pq.size()!= 1){
            int x = pq.poll();
            int y = pq.poll();
            sum += x + y;
            pq.add(x+y);
        }
        System.out.println(sum);
//        Arrays.sort(cards);
//        sums[0] = cards[0] + cards[1];
//        for(int i = 1; i < sums.length ; ++i){
//            sums[i] = sums[i-1] + cards[i+1];
//        }
//        long result = 0;
//        for(int i = 0; i < sums.length ; ++i){
//            result += sums[i];
//        }
//        System.out.println(result);

    }
}