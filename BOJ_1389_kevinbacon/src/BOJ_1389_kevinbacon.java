import java.io.*;
import java.util.*;

public class BOJ_1389_kevinbacon{
    public static ArrayList<Integer>[] arr;
    public static int kevinBacon = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); //유저 수
        int M = Integer.parseInt(st.nextToken()); //관계 수
        arr = new ArrayList[N];
        for(int i = 0 ; i < N ; ++i){
            arr[i] = new ArrayList<>();
        }

        for(int i =  0 ; i< M ;++i){
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            //친구는 양방향  그래프
            arr[u].add(v);
            arr[v].add(u);
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i <= N ;++i){
            kevinBacon = 0;
            BFS(i);
            min = Math.min(kevinBacon, min);
        }
        System.out.print(sb);
    }
    public static void BFS(int nodeIndex){

    }
}