import java.io.*;
import java.util.*;

public class BOJ_11725_findTreeParent{
    public static ArrayList<Integer>[] tree;
    public static boolean[] visited;
    public static int[] answer;

    public static void DFS(int now){
        visited[now] = true;

        for(int node : tree[now]){
            if(!visited[node]){
                answer[node] = now; //부모노드 입력
                DFS(node);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        System.out.print(sb);

        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        visited = new boolean[N+1];
        answer = new int[N+1];

        for(int i = 0 ; i < tree.length ; ++i){
            tree[i] = new ArrayList<>();
        }
        for(int i = 1 ; i < N ; ++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }
        DFS(1);

        for(int i = 2 ; i <= N ; ++i){
            sb.append(answer[i] + "\n");
        }

        System.out.println(sb);
    }
}
