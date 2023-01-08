import java.io.*;
import java.util.*;

public class BOJ_11866_Josephus0{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Queue<Integer> q = new LinkedList<>();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        sb.append("<");
        for(int i = 1 ; i<= N ; ++i){
            q.add(i);
        }

        int cnt = 1;
        while(!q.isEmpty()){
            if(cnt%K==0){
                sb.append(q.poll() +", ");
            }else{
                q.add(q.poll());//뺀걸 다시 큐에 넣음
            }

            cnt++;
        }
        System.out.print(sb.substring(0,sb.length()-2) + ">");

    }
}