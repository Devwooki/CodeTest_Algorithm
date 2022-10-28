//import java.io.IOException;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//  2자리의 숫자가 나오면 오류 발생, 계산 -> 치환이 아닌 계산식 그대로 사용권장
//public class BOJ_1935_LRV2 {
//    public static void main(String[] args)throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int TC = Integer.parseInt(br.readLine());
//        Stack<Double> stack = new Stack<>();
//        String str = br.readLine();
//        char start = 'A'; //A의 아스키 코드값 65
//        int str_start = 0;
//        //ABC 문자 숫자로 변경
//        for(int i = 0 ; i < TC ; i++){
//            String input = br.readLine();
//            for(int j = str_start ; j < str.length() ; j++){
//                char c = str.charAt(j);
//                if(c == start){
//                    str  = str.replace(Character.toString(start), input);
//                    start++;
//                    str_start++;
//                    break;
//                }else continue;
//            }
//        }
//        System.out.println(str);
//        //스택에 피연산자 넣음, 연산자 나오면 pop 2번 해서 계산해서 저장
//       for(int i = 0 ; i < str.length() ; i++){
//           char c = str.charAt(i);
//           double num1;
//           double num2;
//
//           switch(c){
//               case '+' :
//                   num1 = stack.pop();
//                   num2 = stack.pop();
//                   stack.push(num2 + num1); break;
//               case '-' :
//                   num1 = stack.pop();
//                   num2 = stack.pop();
//                   stack.push(num2 - num1); break;
//               case '*' :
//                   num1 = stack.pop();
//                   num2 = stack.pop();
//                   stack.push(num2 * num1); break;
//               case '/' :
//                   num1 = stack.pop();
//                   num2 = stack.pop();
//                   stack.push(num2 / num1); break;
//               default : stack.push(Double.parseDouble(Character.toString(c)));
//           }
//
//        }
//
//        System.out.printf("%.2f", stack.pop());
//    }
//}

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1935_LRV2 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        String str = br.readLine();

        //피연산자 초기화
        double[] arr = new double[TC];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = Double.parseDouble(br.readLine());
        }

        //스택에 피연산자 넣음, 연산자 나오면 pop 2번 해서 계산해서 push, 연산 끝나면 마지막 pop하여 출력
        Stack<Double> stack = new Stack<>();
        for(int i = 0 ; i < str.length() ; i++){
            char c = str.charAt(i);
            // strEX : ABC*+DE/-
            // arrEX : [1, 2, 3, 4, 5]
            if(c  >= 'A' && c <=  'Z'){
                stack.push(arr[c-'A']);
            }
            double num1;
            double num2;
            // 스택은 LIFO 구조 -> 늦게 pop된 num이 피연산자가 좌측 5/4 와 4/5연산은 다르니
            switch(c){
                case '+' :
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 + num1); break;
                case '-' :
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 - num1); break;
                case '*' :
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 * num1); break;
                case '/' :
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 / num1); break;
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}