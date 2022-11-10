import java.io.*;
import java.util.*;

public class BOJ_17298_rightBigNum{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; ++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //후입 선출 : 가장 최근이 가장 먼저 나옴
        //현재 오른쪽 숫자보다 가장 왼쪽에 있는  원소를 뽑는 것
        // 스택이 비어있음(첫시작이나 변경완료 -> 현재 idx 스택에 push)
        //수열을 탐색하면서(for문 1개) 현재원소가 이전원소보다 작을 때 까지 stack에 index push
        //현재원소가 스택 top보다 크면 stack.isEmpty() 까지 배열[stack.pop())으로 대체
        for(int i = 0 ; i < N ; ++i){
//            int rightBigNum  = 0;
//            //현재수열보다 크면  push
//            for(int j = i+1 ; j < N ;++j){
//                if(arr[i] < arr[j])
//                    stack.push(arr[j]);
//            }
//            //마지막까지 꺼낸 값을 출력
//            while(!stack.isEmpty()){
//                rightBigNum = stack.pop();
//            }
//            if(rightBigNum  == 0 ) sb.append(-1).append(" ");
//            else sb.append(rightBigNum).append(" ");
            //첫 순서는 무조건 stack에 인덱스push
            if(i == 0){
                stack.push(i);
                continue;
            }
            //스택이 비어있지 않고 현재  arr[i]값이 arr[stack.peek()]보다 크면 -> pop
            //이전이 크면 push / 이전이 작으면 빌때 까지  pop해서 arr[i]값으로 변환
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                int idx = stack.pop();
                arr[idx] = arr[i];
            }
            stack.push(i);
        }

        //스택에 남은 요소(가장 큰 수들)은 pop하면서 -1로 초기회
        while(!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }

        for(int i = 0 ; i < N ; i++){
            sb.append(arr[i]).append(" ");
        }

        System.out.print(sb);
    }
}