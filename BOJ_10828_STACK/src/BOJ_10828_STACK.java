import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10828_STACK {
    public static int[] arr;
    public static int top = 0;
    public static int size = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        arr = new int[num];
        StringTokenizer st;
        int pushValue = 0;
        for(int i = 0 ; i < num ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();
            switch (cmd) {
                case "push" -> {
                    int data = Integer.parseInt(st.nextToken());
                    push(data);
                }
                case "pop" -> pop();
                case "size" -> mysize();
                case "empty" -> empty();
                case "top" -> top();
            }
        }
    }

    public static void push(int num){// 스택에 넣기
        arr[top] = num;
        top++;
    }
    public static void pop(){ // 가장 위에 수 빼고 수 출력, 정수가 없으면  -1
        if(top == 0) System.out.println(-1);
        else{
            System.out.println(arr[top-1]);
            arr[top-1] = 0;
            top--;
        }
    }
    public static void mysize(){ //스택에 들어있는 정수의 수
        System.out.println(top);
    }
    public static void empty(){ //스택이 비어있으면 1, 아니면 0
        if(top == 0) System.out.println(1);
        else System.out.println(0);
    }
    public static void top(){ // 가장 위의 정수  출력, 없으면 -1
        if(top == 0) System.out.println(-1);
        else System.out.println(arr[top-1]);
    }
}