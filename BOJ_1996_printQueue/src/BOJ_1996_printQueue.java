import java.io.*;
import java.util.*;
//문서 수와 중요도가 주어졌을 때 몇 번째로 인쇄되는지 알아네기

public class BOJ_1996_printQueue{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int TC = Integer.parseInt(br.readLine());
        for(int test = 0 ; test < TC ; ++test){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken()); //문서 갯수
            int M = Integer.parseInt(st.nextToken()); //Q에 몇 번째에 놓여있는지

            LinkedList<int[]> q =  new LinkedList<>();
            st = new StringTokenizer(br.readLine()," ");

            for(int i = 0 ; i <  N ;++i){
                int x = Integer.parseInt(st.nextToken());
                q.add(new int[] {i, x});
            }

            int cnt = 0;//출력횟수
            while (!q.isEmpty()) {
                int[] front = q.poll();//큐에서 하나꺼냄
                boolean isMax= true;  //꺼낸것 중요도가 가장 높다고 가정

                for(int i = 0 ; i < q.size(); ++i){
                    if(front[1] < q.get(i)[1]) {//처음 뽑은 것 보다

                        q.add(front);
                        for(int j = 0 ;  j<i ; ++j){
                            q.add(q.poll());
                        }

                        isMax = false;
                        break;
                    }
                }
                //front원소가 가장 큰 값이 아니였으니 다음으로 넘어감
                if(isMax == false) continue;

                //front가 가장 컸으니 해당원소 출력
                cnt++;
                if(front[0] == M){
                    break;
                }
            }
            sb.append(cnt+"\n");
        }
        System.out.print(sb);
    }
}