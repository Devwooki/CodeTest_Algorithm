import java.util.*;

class Solution {
    
    ArrayList<Node>[] graph;
    int[] dist;
    public int solution(int N, int[][] road, int K) {
        //정점이 1부터 시작하니 계산하기 쉽게 하기 위해
        graph = new ArrayList[N + 1];
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        //1번 정점에서 자기자신의 거리는 이므로
        for(int i = 1 ; i <= N ; ++i){
            graph[i] = new ArrayList<>();
        }
        
        int roadSize = road.length;
        for(int i = 0 ; i < roadSize ; ++i){
            int u = road[i][0];
            int v = road[i][1];
            int w = road[i][2];
            
            //무방향 그래프 이므로 양쪽에 넣는다.
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }
        
        dist[1] = 0;
        
        return dijkstra(K, dist, N);
    }
    
    public int dijkstra(int k, int[] dist, int n){
        int cnt = 0;
        
        //우선순위 큐 선언
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.w - o2.w;
        });
        
        //출발지 1번
        pq.offer(new Node(1, 0));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            //최단 거리 갱신이 불가능 하면 스킵
            if(cur.w > dist[cur.v]) continue;
            
            for(Node next : graph[cur.v]){
                //다음 노드로 이동시 비용 계산
                int cost = next.w + dist[cur.v];
                
                if(cost <= dist[next.v]){
                    dist[next.v] = cost;
                    pq.offer(new Node(next.v, cost));
                }
            }
        }
        
        //배달 가능한 지점을 구한다.
        for(int i = 1 ; i <= n ; ++i){
            if(dist[i] <= k) cnt++;
        }
        return cnt;
    }
    
    class Node {
        int v;
        int w;
        
        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
}












// import java.util.*;

// class Solution {   
//     ArrayList<Node>[] graph;

//     public int solution(int N, int[][] road, int K) {
//         graph = new ArrayList[N+1];

//         for(int i = 0 ; i <= N ; ++i){
//             graph[i] = new ArrayList<>();
//         }
        
//         int roadSize = road.length;
//         for(int i = 0 ; i < roadSize ; ++i){
//             //인덱스 계산하기 귀찮으므로..
//             int u = road[i][0];
//             int v = road[i][1];
//             int w = road[i][2];
            
//             //무방향(양방향 그래프 이기에 둘 다 넣어준다)
//             graph[u].add(new Node(v, w));
//             graph[v].add(new Node(u, w));
//         }

//         return bfs(N, K);
//     }
//     /*
//     1번 마을의 있는 음식점이 K 이하의 시간에 배달이 가능한 마을의 갯수 구하면 됨
//     */
//     public int bfs(int n, int k){
    
//         int[] dist = new int[n+1];
//         Arrays.fill(dist, Integer.MAX_VALUE);
//         //첫 정점의 거리는 0이다
//         dist[1] = 0;
        
//         //거리가 가까운 순으로 정렬한다.
//         PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
//             return o1.w - o2.w;
//         });
        
//         //첫 번째 정점에서 시작
//         pq.offer(new Node(1, 0));
        
//         while(!pq.isEmpty()){
//             Node cur = pq.poll();
            
//             //현재 노드까지 이용한 비용이, 현재 거리보다 크면 무시
//             if(cur.w > dist[cur.v]) continue;
            
//             for(Node next : graph[cur.v]){
//                 int cost = next.w + dist[cur.v];
                
//                 if(cost < dist[next.v]){
//                     dist[next.v] = cost;
//                     pq.offer(new Node(next.v, cost));
//                 }
//             }
//         }
        
//         int cnt = 0;
//         for(int i = 1 ; i <= n ; ++i){
//             if(dist[i] <= k) cnt++;
//         }
        
//         return cnt;
//     }
//     class Node {
//         int v;
//         int w;
        
//         public Node(int v, int w){
//             this.v = v;
//             this.w = w;
//         }
//     }
// }