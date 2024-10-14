import java.util.*;
import java.awt.*;

class Solution {
    int[][] dir = {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}
    };
    int answer = -1;
    int[][] visit;
    Point locR;
    int N, M; //세로, 가로
    public int solution(String[] board) {
        //초기값 선언
        int boardSize = N = board.length;
        M = board[0].length();
    
        visit = new int[N][M];
        
        //값 초기화
        findR:
        for(int i = 0 ; i < boardSize ; ++i){
            String temp = board[i];
            for(int j = 0 ; j < temp.length() ; ++j){
                if(board[i].charAt(j) == 'R'){
                    locR = new Point(j, i);  
                    break findR;
                } 
            }
        }
        
        BFS(board);
        
        return answer;
    }
    
    public void BFS(String[] board){
        Queue<Point> q = new LinkedList<>();
        q.offer(locR);
        visit[locR.y][locR.x] = 1;
        
        while(!q.isEmpty()){
            Point curr = q.poll();
            
            //도착한 곳이골이라면 방문 횟수 1줄임(q에 넣기전에 +1 했으므로)
            if(board[curr.y].charAt(curr.x) == 'G'){
                answer = visit[curr.y][curr.x] - 1;
                break;
            }        
            
            //네 방향 탐색
            for(int i = 0 ; i < 4 ; ++i){
                int nx = curr.x + dir[i][0];
                int ny = curr.y + dir[i][1];
                
                //직진을 시작한다.
                while(true){
                    //범위를 충족하고 장애물을 만나지 않았을 경우
                    if(checkRange(nx, ny) && board[ny].charAt(nx) != 'D'){
                        nx += dir[i][0];
                        ny += dir[i][1];
                    }else{//회전
                        nx -= dir[i][0];
                        ny -= dir[i][1];
                        break;
                    }
                } 
                
                //이동한 위치가 방문하지 않은 곳이라면 BFS 다시 수행
                //최소횟수를 찾기 위함
                if(visit[ny][nx] == 0){
                    q.offer(new Point(nx, ny));
                    visit[ny][nx] = visit[curr.y][curr.x] + 1;
                }
            }
        }
        
    }
    
    public boolean checkRange(int x, int y){
        return ( 0 <= x && x < M && 0 <= y && y < N) ;
    }
}