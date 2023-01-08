//import java.io.*;
//import java.util.*;
////방문할 수 있는 노드가 여러개면 노드번호가 작은 것 부터 방문,  더이상  방문 불가능하면 종료
//public class BOJ_1260_DFSnBFS{
//    public static ArrayList<Integer>[] list;
//    public static  boolean visited[];
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine()," ");
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//        int V = Integer.parseInt(st.nextToken());
//        list = new ArrayList[N+1];
//
//
//        for(int i = 1 ; i <= N ;++i){
//            list[i] = new ArrayList<Integer>();
//        }
//        //노드번호가 작은 것 부터 방문,  더이상  방문 불가능하면 종료
//        for(int i = 1 ; i <= N ; ++i){
//            Collections.sort(list[i]);
//        }
//        for(int i = 0 ; i < M ;++i){
//            st = new StringTokenizer(br.readLine(), " ");
//            int u = Integer.parseInt(st.nextToken());
//            int v = Integer.parseInt(st.nextToken());
//
//            list[u].add(v);
//            list[v].add(u);
//        }
//
//        visited = new boolean[N+1];//방문배열 초기화 후
//        DFS(V);
//        System.out.println();
//        visited = new boolean[N+1];//방문배열 초기화 후
//        BFS(V);
//
//
//        //1번줄 DFS, 2번줄 BFS
//    }
//
//    public static void DFS(int nodeIDX){
//        System.out.print(nodeIDX + " ");
//        if(visited[nodeIDX]) return; //방문했으면 종료
//
//        //방문 안했으면 현재 노드 방문
//        visited[nodeIDX] = true;
//        for(int k : list[nodeIDX]){ //현재노드의 인접리스트
//            if(!visited[k]){
//                DFS(k);
//            }
//        }
//    }
//
//    public static void BFS(int nodeIDX){
//
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(nodeIDX);             //큐 자로규조에 시작노드 삽입
//        visited[nodeIDX] = true;        //visited배열에 현재 노드기록
//        while(!queue.isEmpty()){
//            int now_Node = queue.poll(); //큐가 비어있을 때 까지 큐의 노드데이터  가져와서
//            System.out.print(now_Node + " ");
//            for(int k :  list[now_Node]){
//                if(!visited[k]){//미방문 노드를 큐에 삽입
//                    queue.add(k);
//                    visited[k] = true;
//                }
//            }
//
//        }
//    }
//}



import java.io.*;
import java.util.*;
//방문할 수 있는 노드가 여러개면 노드번호가 작은 것 부터 방문,  더이상  방문 불가능하면 종료
public class BOJ_1260_DFSnBFS{
    public static ArrayList<Integer>[] list;
    public static  boolean visited[];
    public static int N, M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i = 1 ; i <= N ; ++i){
            list[i] = new ArrayList<Integer>();
        }

        for(int i = 0 ; i < M ; ++i){
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        //번호가 작은 것 부터 방문하기 위해 정렬
        for(int i = 1 ; i <= N ; ++i){
            Collections.sort(list[i]);
        }

        DFS(V);
        System.out.println();
        visited = new boolean[N+1]; //BFS탐색을 해야하므로 방문 배열 초기화
        BFS(V);

    }

    public static void DFS(int nodeIDX){
        if(visited[nodeIDX]) return;//현재노드 방문했으면 종료
        System.out.print(nodeIDX + " ");//현재 노드 인덱스 출력하고

        visited[nodeIDX] = true; //현재 노드  방문표시
        for(int k : list[nodeIDX]){
            if(!visited[k]) DFS(k);
        }
    }

    public static void BFS(int nodeIDX){//
        Queue<Integer> q = new LinkedList<>();//큐 생성
        q.add(nodeIDX); //큐에 현재 노드 삽입
        visited[nodeIDX] = true; //현재 노드 방문처리

        while(!q.isEmpty()){ //큐가 빌 때 까지 반복
            int now = q.poll();
            System.out.print(now + " ");

            for(int k : list[now]){ //현재 노드의 인접리스트  검토
                if(!visited[k]){    //인접리스트가 방문 안됫으면 큐에 넣음
                    q.add(k);
                    visited[k] = true; //큐에 넣었으니 방문한거임
                }
            }
        }
    }
}

