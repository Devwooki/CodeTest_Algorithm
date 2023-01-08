//import java.io.*;
//import java.util.*;
//
//public class BOJ_2178_escapleMaze_BFS{
//    //위 오른쪽 아래 왼쪽탐색 가능하며 상하좌우만 ㅇ ㅣ동
//    public static int[] dx = {0,1,0,-1};
//    public static int[] dy = {1,0,-1,0};
//    public static boolean[][] visited;
//    public static int[][] maze;
//    public static int N;
//    public static int M;
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine()," ");
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        visited = new boolean[N][M];
//        maze = new int[N][M];
//        for(int i = 0 ; i < N  ; ++i){
//            st = new StringTokenizer(br.readLine());
//            String str = st.nextToken();
//            for(int j = 0 ; j < M  ; ++j){
//                maze[i][j] = Integer.parseInt(str.substring(j,j+1));//한 글자씩 넣어 미로에 초기화
//            }
//        }
//        BFS(0,0);
//        System.out.println(maze[N-1][M-1]);
//
//    }
//
//    public static void BFS(int x, int y ){
//        Queue<int[]>  queue = new LinkedList<>();
//        queue.add(new int[] {y, x}); //현재 위치 큐에 삽입
//        visited[y][x] = true; //현재 큐 방문
//
//        while(!queue.isEmpty()){
//            int now[] = queue.poll(); //큐에서 하나꺼내서
//            for(int k = 0 ;  k < 4 ; ++k){  //4방향 탐색
//                int nowX = now[1] + dx[k];
//                int nowY = now[0] + dy[k];
//                if(nowX >= 0 && nowX < M && nowY >= 0  && nowY < N) {//좌표가 유효한지 확인
//                    //유요하므로 이동할 수 있는 칸이고 방문하지 않았으면
//                    //인접노드 queue에 삽입하고 visited true로 변경
//                    if(maze[nowY][nowX]!= 0 && !visited[nowY][nowX]){
//                        visited[nowY][nowX] = true;
//                        maze[nowY][nowX] = maze[now[0]][now[1]] +1;//탐색횟수 누적시킴
//                        queue.add(new int[] {nowY, nowX});
//                    }
//                }
//            }
//        }
//    }
//}


import java.io.*;
import java.util.*;

public class BOJ_2178_escapleMaze_BFS{
    public static boolean[][] visited;
    public static int[][] maze;
    public static int N,M;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1][M+1];
        maze = new int[N+1][M+1];
        for(int i = 1 ; i <= N ;++i){
            String str = br.readLine();
            for(int j = 1 ; j <= M ; ++j){
                maze[i][j] = Integer.parseInt(String.valueOf(str.charAt(j-1)));
                //1은 갈 수 있고 0은 못감
            }
        }
        BFS(1,1);
        System.out.println(maze[N][M]);

    }

    public static void BFS(int x, int y ){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y,x});
        visited[y][x] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0 ; i < 4 ; ++i){
                int nowX = now[1] + dx[i];
                int nowY = now[0] + dy[i];
                //좌표 유효성 검사
                if(nowX > 0 && nowX <= M && nowY > 0 && nowY <= N){
                    if(maze[nowY][nowX]!=0 && !visited[nowY][nowX]){ //방문여부 확인및 이동 가능한지 확인
                        visited[nowY][nowX] = true; //노드 방문했고
                        maze[nowY][nowX] = maze[now[0]][now[1]]+1; //다음 노드까지 탐색횟수는 직전 노드의 +1
                        q.add(new int[] {nowY, nowX});

                    }
                }

            }
        }
    }
}
