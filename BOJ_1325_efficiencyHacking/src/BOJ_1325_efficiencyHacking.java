import java.io.*;
import java.util.*;

public class BOJ_1325_efficiencyHacking{
    public static ArrayList<Integer>[] network;
    public static int[] count;
    public static void BFS(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int now = q.poll();
            for(int node : network[now]){
                q.add(node);
                count[node]++;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //노드 수
        int M = Integer.parseInt(st.nextToken()); //간선 수

        network = new ArrayList[N+1];
        count = new int[N+1];

        for(int i = 1 ; i <= N ; ++i){
            network[i] = new ArrayList<>();
        }
        for(int i = 1 ; i <= M ; ++i){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            network[A].add(B);
        }

        //노드별로 탐색
        for(int i = 1 ; i <= N ; ++i){
            BFS(i);
        }

        //최댓값을 가진 노드 찾기
        int max = Integer.MIN_VALUE;
        for(int i = 1 ; i <= N ; ++i){
            max = Math.max(count[i], max);
        }

        for(int i = 1 ; i <= N ;++i){
            if(count[i] == max){
                sb.append(i+" ");
            }
        }

        System.out.println(sb);
    }}
