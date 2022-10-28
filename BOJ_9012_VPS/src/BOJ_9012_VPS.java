import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import  java.util.Stack;

public class BOJ_9012_VPS {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < TC ; i++){
            sb.append(isVPS(br.readLine())).append("\n");
        }

        System.out.println(sb);
    }

    public static String isVPS(String args){
        Stack<String> myStack = new Stack<String>();
        for(int j = 0 ; j < args.length() ; j++){ //입력받은 문자열 vps 판별하기
            // (와 )  수가 같을 때 -> (면  push,  )면 pop -> 마지막에 empty-> vps
            // (가 더  많을 때 -> pop해도 남음 -> no 출력
            // )가 더 많을 때 ->  pop에러 발생 -> no 출력

            if(args.charAt(j) == '(')
                myStack.push("(");

            else if(myStack.isEmpty())
                return "NO";

            else // -> args.charAt(j)가 )이면 pop
                myStack.pop();

        }
        if(myStack.isEmpty()) return "YES";
        else return "NO";
    }
}