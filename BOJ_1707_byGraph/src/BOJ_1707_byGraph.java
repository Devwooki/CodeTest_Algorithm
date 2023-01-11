import java.io.*;
import java.util.*;
//이분 그래프 : 서로 인접하지 않는 두 집합으로, 그래프의 노드를 나눌 수 있을 때
public class BOJ_1707_byGraph{
    public static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        System.out.print(sb);

        int K = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= K ; ++i){
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V+1];
            for(int j = 1 ; j <= V; ++j){
                graph[i] = new ArrayList<>();
            }

            for(int j = 1 ; j <= E; ++j){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
            }
        }

    }
}