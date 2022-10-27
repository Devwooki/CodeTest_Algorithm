import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_1918_LRV {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String LVR = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < LVR.length(); i++) {
            char c = LVR.charAt(i);

            //c가 문자면 그냥 출력
            if (c >= 'A' && c <= 'Z'){
                sb.append(c);
                continue;
            }

            //연산자면 스택에 넣고 뻄, 우선순위에 기준
            // )이면 (가 나올 떄 까지 stack안 연산자 pop!
            if (c=='('){
                stack.push(c);
                continue;
            }
            if(c == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    sb.append(stack.pop()); //스택안 연산자 pop
                }
                stack.pop();// )뺌
                continue;
            }
            while(!stack.isEmpty() && priority(c) <= priority(stack.peek())){
                sb.append(stack.pop());
            }
            stack.push(c);
            //현재 연산자(priority(c)) 우선순위보다 큰 연산자가 stack 맨 위에 있다면 없을 때 까지 pop
            // -> 우선순위 큰게 먼저 계산되야하므로
        }

        while(!stack.isEmpty())
            sb.append(stack.pop());

        System.out.println(sb);

    }

    public static int priority(char  c){
        if(c == '(' || c == ')')
            return 0;
        else if (c == '+' || c == '-')
            return 1;
        else if (c == '*' || c == '/')
            return 2;
        return -1;
    }
}
