import java.io.*;
import java.util.*;

public class BOJ_18352_shortestPath{
    public static void BFS(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 0;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int node : graph[now]){
                if(visited[node] == -1){ //방문 안한 노드면
                    q.add(node);
                    visited[node] =  visited[now]+1;
                }
            }
        }
    }

    public static int N, M, K, X;
    public static ArrayList<Integer>[] graph;
    public static int[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //노드 수
        M = Integer.parseInt(st.nextToken()); //간선 수
        K = Integer.parseInt(st.nextToken()); //거리 정보
        X = Integer.parseInt(st.nextToken()); //출발 도시 번호

        visited = new int[N+1];
        graph = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; ++i){
            graph[i] = new ArrayList<>();
            visited[i] = -1;
        }
        for(int i = 0 ; i < M ; ++i){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B);
        }

        BFS(X);

        List<Integer> result = new LinkedList<>();
        for(int i = 1 ; i <= N ; ++i){
            if(visited[i] == K){
                result.add(i);
            }
        }

        if(result.isEmpty()){
            System.out.println(-1);
        }else{
            Collections.sort(result);
            for(int k : result){
                System.out.println(k);
            }
        }
    }
}
