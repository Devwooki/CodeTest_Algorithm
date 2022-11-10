import java.io.*;
import java.util.*;

public class BOJ_2304_polygon {
    /*
    배열에 저장
    -> start위치와 end 위치 저장
    -> 가장 높은 값과 idx 기억
    0~idx까지  다각형 구하기
    n-1 ~ idx까지 다각형
    -> 마지막에 가장 큰 높이 더하기
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[16];
        int start  = Integer.MAX_VALUE;
        int end = 0;
        int result = 0;
        Stack<Integer> height = new Stack<Integer>();

        for(int i = 0 ; i < N ; ++i){
            st = new StringTokenizer(br.readLine(), " ");
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            arr[L] = H;
            start = Math.min(start, L);
            end = Math.max(end,L);
        }

        //왼쪽 탐색
        /*
        현재 높이 > 다음 높이가 : 위치 stack에  push
        -> 현재 높이 < 다음 높이 -> stack에 저장된 위치 꺼내 0을 현재 높이로 바꿈
         */
        int temp = arr[start];
        for(int i = start + 1 ; i <= end ; ++i){
            if(temp > arr[i]) height.push(i);
            else{
                while(!height.isEmpty()){
                    int x = height.pop();
                    arr[x] = temp;
                }
                temp = arr[i];
            }
        }
        height.clear();
        //오른쪽 탐색 - 왼쪽과 반대 현재높이가 이전 높이보다 크면 위치 stack에 push
        //                      현재높이 < 이전높이 ->  stack에서  위치 꺼내 0을 현재 높이로 바꿈
        temp = arr[end];
        for(int i = end-1 ; i >= start ; i--){
            if(temp > arr[i]) height.push(i);
            else{
                while(!height.isEmpty()){
                    int x = height.pop();
                    arr[x] = temp;
                }
                temp =arr[i];
            }
        }

        //배열 : 위치 기준 오름차순 정렬

        for(int i = start ; i <= end ; i++){
            result += arr[i];
        }

        System.out.println(result);
    }
}


