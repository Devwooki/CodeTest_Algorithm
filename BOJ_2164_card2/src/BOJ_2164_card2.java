import java.io.*;
import java.util.*;

public class BOJ_2164_card2{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= N ;++i){
            q.add(i);
        }
        while(q.size()!=1){
            q.poll();
            q.add(q.poll());
        }
        System.out.print(q.poll());

    }
}