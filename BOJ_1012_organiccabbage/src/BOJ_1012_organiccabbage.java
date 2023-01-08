import java.io.*;
import java.util.*;
/*
배추가 상하좌우에 위치 -> 인접한 것
배추가 모인 곳에 흰 지렁이 1마리 있으면 전부 예방이 됨
1 : 배추
0 배추 없음
 */
public class BOJ_1012_organiccabbage{
    public static int[][]  map;
    public static boolean[][]  visited;
    public static int N, M, cnt;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1,  0};

    public static void DFS(int x, int y){

       /*
        입력받은 xy를 기준으로 상하좌우가 1인지 확인
       */
        visited[y][x] = true;
        for(int i = 0 ; i < 4 ; ++i){
            int next_x = x + dx[i];
            int next_y = y + dy[i];
            if(next_x >= 0 && next_x < M && next_y>=0 && next_y < N){//좌표 유효성 검사
                if(!visited[next_y][next_x] && map[next_y][next_x] == 1){ //방문 안했으면
                    DFS(next_x, next_y);
                }
            }
        }
    }

    public static void BFS(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});

        while(!q.isEmpty()){
            int[] temp = q.poll();
            visited[temp[1]][temp[0]] = true;
            for(int i = 0 ; i < 4 ; ++i){
                int next_x = temp[0] + dx[i];
                int next_y = temp[1] + dy[i];
                if(next_x >= 0 && next_x < M && next_y>=0 && next_y < N){//좌표 유효성 검사
                    if(!visited[next_y][next_x] && map[next_y][next_x] == 1){ //방문 안했으면
                        q.add(new int[] {next_x, next_y});
                        visited[next_y][next_x] =  true;
                    }
                }
            }
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        for(int test = 1 ;  test <= TC ; ++test){
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];
            int K = Integer.parseInt(st.nextToken());
            for(int i = 0 ; i < K ; ++i){
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }
            cnt = 0;
            for(int i = 0 ; i < N ; ++i){
                for(int j = 0 ; j < M ; ++j){
                    if(!visited[i][j] && map[i][j] == 1) {//배추가 있고 방문 하지 않았으면 DFS실시
                        BFS(j, i);
                        cnt++;
                    }
                }
            }

            sb.append(cnt+"\n");
            cnt = 0;
        }

        System.out.print(sb);

    }

}
