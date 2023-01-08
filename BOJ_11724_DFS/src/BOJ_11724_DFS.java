import java.io.*;
import java.util.*;

public class BOJ_11724_DFS{
    public static ArrayList<Integer>[] list;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N  = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        //인접리스트 초기화
        for(int i = 1 ; i <= N ; ++i){
            list[i] = new ArrayList<Integer>();
        }

        for(int i = 0 ; i < M ;++i){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            //무방향 그래프(양방향)이므로  둘 다넣어줌
            list[u].add(v);
            list[v].add(u);
        }
        int cnt = 0;
        for(int i = 1; i <= N ; ++i){
            if(!visited[i]){
                cnt++;
                DFS(i);
            }
        }
        System.out.println(cnt);
    }

    public static void DFS(int nodeIdx){
        if(visited[nodeIdx]) return; //방문했으면 종료

        //현재노드 방문했다고 하고 이어진 노드들 찾기
        visited[nodeIdx] = true;
        for(int i : list[nodeIdx]){//현재 리스트의 모든 원소에 접근해서 DFS 실시
            if(visited[i] == false) DFS(i);
        }

    }
}