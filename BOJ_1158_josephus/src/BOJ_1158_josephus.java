import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_1158_josephus {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Queue<Integer> josephus = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        sb.append("<");

        int num = Integer.parseInt(st.nextToken());
        int slice = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= num; i++) {
            josephus.add(i);
        }

        //for (int i = 0; i < num; i++) {
        while(josephus.size() > 1 ){
            for (int j = 0; j < slice-1; j++) {
                int val = josephus.poll();
                josephus.add(val);
            }
            sb.append(josephus.poll()).append(", ");
        }
        sb.append(josephus.poll()).append(">");

        System.out.println(sb);
    }
}