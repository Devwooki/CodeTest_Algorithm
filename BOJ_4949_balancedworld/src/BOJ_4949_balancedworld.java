import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_4949_balancedworld {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if(s.equals(".")) break; // 입력 종료 조건으로 맨 만지막에 점이 들어오면 종료

            sb.append(solve(s)).append("\n");
        }

        System.out.println(sb);
    }

    public static String solve(String str){
        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < str.length() ; i++){
            if(str.charAt(i) == '(' || str.charAt(i) == '[')
                stack.push(str.charAt(i));

//            else if ((str.charAt(i) == ')')) {
//                if( stack.isEmpty() || stack.peek() != '(') {
//                    return  "no";
//                }else {
//                    stack.pop();
//                }
//            }
//
//            else if ((str.charAt(i) == ']')) {
//                if(stack.isEmpty() || stack.peek() != '[') {
//                    return "no";
//                }else {
//                    stack.pop();
//                }
//            }
//        }

            else if ((str.charAt(i) == ')')) {
                if( !stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }else {
                    stack.push(str.charAt(i));
                }
            }

            else if ((str.charAt(i) == ']')) {
                if( !stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                }else {
                    stack.push(str.charAt(i));
                }
            }
        }

        if(stack.isEmpty())
            return "yes";
        else
            return "no";
    }
}