import java.io.*;
import java.util.*;

public class BOJ_13023_friends {
    public static ArrayList<Integer>[] list;
    public static boolean isFriends[];
    public static boolean isSame;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        isSame = false;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];
        isFriends = new boolean[N];
        for(int i = 0  ; i < N ; ++i){
            list[i] = new ArrayList<Integer>();
        }

        for(int i = 0 ; i < M ; ++i){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            //친구관계 - 방향이 없는 무방향 -> 양방향 저장
            list[a].add(b);
            list[b].add(a);
        }

        //depth가  5면 종료시킨다
        //추가로 하나의  dfs가 끝나면 vistied를 전부 false로  초기화해야함
        // 그래야 다음 노드의 depth를 측정할 수 있으므로
        for(int i = 0 ; i < N ;++i){
            Arrays.fill(isFriends,false); //매 탐색마다 방문 배열 초기화
            DFS(i, 1);

            if(isSame) break; //조건이 같은 것을 발견하면 탐색 종료
        }
        if(isSame) System.out.println(1);
        else System.out.println(0);
    }

    public static void DFS(int nodeIDX,int depth){
        if(depth>=5) {
            isSame = true;  //깊이가 5이상이면 abcde구조와 같으므로 isSame = true로 변경하고 재귀 종료
            return ;
        }

        for(int i : list[nodeIDX]){
            if(!isFriends[i]){ //방문하지 않았다면
                isFriends[nodeIDX] = true;//현재노드 방문햇다 체크하고 다음 노드로 넘어가면서 depth증가
                DFS(i, depth+1); //다음 인덱스로 넘어가며  depth 증가
                isFriends[nodeIDX] = false; //방문 배열 초기화 실시
            }
        }
    }
}
