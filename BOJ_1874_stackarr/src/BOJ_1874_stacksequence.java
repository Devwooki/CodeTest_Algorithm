import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
public class BOJ_1874_stacksequence {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 1부터 N까지의 수를 스택에 넣었다 빼서 2번째 줄부터의 수열을 만들 수 잇음!
        //  첫 시작은 무조건 1
        //둘째 줄 부터의 데이터를 오름차순 입력된 스택에서 push pop 연산을 통해 만들 수 있는가? 라는문제
        Stack<Integer> myStack = new Stack<>();

        int startPoint = 1;
        for(int i = 0; i < TC ; i++){   // 수열 갯수 만큼 반복

            int temp = Integer.parseInt(br.readLine());

            for(; startPoint <= temp ; startPoint++){
                myStack.push(startPoint);
                sb.append("+").append("\n");
            }

            if(myStack.peek() == temp){
                myStack.pop();
                sb.append("-").append("\n");

            }else{
                System.out.println("NO");
                System.exit(0);
            }

        }

//        for(int i = 0; i < TC ; i++){   // 수열 갯수 만큼 반복
//
//            int temp = Integer.parseInt(br.readLine());
//
//            if(startPoint < temp ){//읽어온 숫자보다 startpoint 작으면
//                for(int j = startPoint + 1 ; j <= temp ; j++){//숫자까지 스택에 오름차순 삽입
//                    myStack.push(j);
//                    sb.append("+").append("\n");
//                }
//                startPoint=temp;
//            }
//
//            else if(myStack.peek() !=  temp){
//                System.out.println("NO");
//                System.exit(0);
//            }
//            myStack.pop();
//            sb.append("-").append("\n");
//
//
//
//        }


        System.out.println(sb);
    }
}