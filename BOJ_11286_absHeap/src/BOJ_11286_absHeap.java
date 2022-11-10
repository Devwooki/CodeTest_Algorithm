import java.io.*;
import java.util.*;

public class BOJ_11286_absHeap{
    public static void main(String[] args) throws IOException{
        //절댓값 가장 작은거  배열에서제거, 절댓값 작은거 여러개일 경우   실제 값이 가장 작은거 출력하고 제고
        //힙이니까 우선순위큐 적용하며, 정렬기준은 위와 같음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            //우선순위 큐는 정렬 기준을만들어줘야한다 comparator
            @Override
            public int compare(Integer i1, Integer i2){
                //절댓값 기준으로 앞의 값이 더 크면 스왑
                if(Math.abs(i1) > Math.abs(i2)) {
                    return Math.abs(i1) - Math.abs(i2);
                    //절대값 기준으로 두 값이 같다면 음수를 앞으로 보내준다.
                }else if(Math.abs(i1) == Math.abs(i2)) {
                    return i1 - i2;
                }else {
                    return -1;
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        //입력에서 0이 주어진 만큼 답을 출력, 배열이 비어있는데 절댓값이 가장 작은 값을 출력할 때 0
        for(int i = 0 ; i < TC ; ++i){
            int x = Integer.parseInt(br.readLine());
            // x==0 -> 큐가 비어있으면 0, 아니면 절댓값이 최소인  값, 절댓값이 같으면 음수 우선
            // x=1 -> add연산 후 우선순위큐 정렬 기준 자동정렬
            if(x == 0){
                if(pq.isEmpty()) sb.append("0").append("\n");
                else sb.append(pq.poll()).append("\n");
            }else{
                pq.add(x);
            }
        }
        System.out.print(sb);

    }
}