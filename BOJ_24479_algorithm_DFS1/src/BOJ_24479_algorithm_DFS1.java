import java.io.*;
import java.util.*;

public class BOJ_24479_algorithm_DFS1{
    public static ArrayList<Integer>[] list;
    public static int[] result;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
    public static int N,M,R,cnt=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];  //그래프
        result = new int[N+1];      //방문순서
        visited = new boolean[N+1]; //방문 여부

        for(int i  = 1 ; i <= N ; ++i){
            list[i] = new ArrayList<Integer>();
        }
        //그래프 생성
        for(int i = 0; i < M ; ++i){
            st = new StringTokenizer(br.readLine());
            int u =  Integer.parseInt(st.nextToken());
            int v =  Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }
        //정점을 오름차순 정렬해야함
        for(int i  = 1 ; i <= N ; ++i){
            Collections.sort(list[i]);
        }
        //정점 R에서 부터  시작해 깊이우선탐색 할 경우 노드 방문 순서 출력
        DFS(R);
        //출력물은  i번쨰 줄의  정점 i의 방문 순서 출력
        for(int i = 1 ; i <= N ; ++i){
            sb.append(result[i]+"\n");
        }

        System.out.println(sb);
    }

    public static void DFS(int nodeIndex){
        if(visited[nodeIndex]) return; //현재노드 방문했다면 패스
        //

        visited[nodeIndex] = true; //방문했으니  true처리
        result[nodeIndex] = ++cnt; //방문 순서 입력력

        for(int i : list[nodeIndex]){//현재 노드의 끝까지  탐색,,
            if(!visited[i]) DFS(i);
        }

    }
}