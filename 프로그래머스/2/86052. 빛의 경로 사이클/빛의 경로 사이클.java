//전일 풀었던 3차원 배열로 방향 확인

import java.util.*;

class Solution {
    int N, M;
    boolean[][][] visited;
    int[][] dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    public int[] solution(String[] grid) {
        List<Integer> answer = new ArrayList<>();
        
        N = grid.length;
        M = grid[0].length();
        visited = new boolean[N][M][4];
        
        for(int i = 0 ; i < N ; ++i){
            for(int j = 0 ; j < M ; ++j){
                //방향관련
                for(int d = 0 ; d < 4 ; ++d){
                    if(!visited[i][j][d]){
                        int cycleCnt = getCycle(grid, j, i, d);
                        answer.add(cycleCnt);
                    }
                }
            }
        }
        
        Collections.sort(answer);
        
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    public int getCycle(String[] grid, int x, int y, int d){
        int cnt = 0;
        
        //방문한 지점 다시 방문시, cycle은 끝나게 된다.
        while(!visited[y][x][d]){
            cnt += 1;
            //현재 지점 방문처리
            visited[y][x][d] = true;
            
            if(grid[y].charAt(x) == 'L'){//좌회전
                d = (d+3) % 4;
            }else if(grid[y].charAt(x) == 'R'){//우회전
                d = (d+1) % 4;
            }
            
            //다음 방향을 지정한다.
            //값을 넘어갈 경우 반대쪽 끝에서 동일하게 오기 때문
            // 예를 들어 M이 일 때 유효 숫자 범위는 0 ~ 3이다.
            // x + dir[d][0]이 -1이면 3의 자리로 가야하기 때문에 + M을 해준다
            x = (x + dir[d][0] + M) % M ;
            y = (y + dir[d][1] + N) % N;
        }
        
        return cnt;
    }
}