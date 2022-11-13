import java.io.*;
import java.util.*;

public class BOJ_11724_DFS{
    public static ArrayList<Integer>[] list;
    public static boolean visited[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        visited= new boolean[N + 1];

        //인접 리스트 초기화
        for(int i = 1 ; i <= N ;++i){
            list[i] = new ArrayList<Integer>();
        }
        //그래프 인접리스트에 그림
        for(int i = 0; i < M ; ++i) {
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            //무방향 그래프(양방향 에지) -> 때문에 둘 다 넣어줌줌
            list[u].add(v);
            list[v].add(u);
        }
        int cnt = 0;

        for(int i = 1 ; i <= N ; ++i){
            if (!visited[i]) {
                cnt++;
                DFS(i);
            }
        }
        System.out.print(cnt);

    }

    public static void DFS (int nodeIndex){
        if(visited[nodeIndex])  return; // 현재 노드 방문 했으면 반환

        visited[nodeIndex] = true;  // 현재노드 방문했으니 true, 남은 연결 노드 중  방문하지 않은 곳만 탐색
        for(int i : list[nodeIndex]){
            if(visited[i] == false) DFS(i);
        }
    }
}