import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799_FePIPE {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<Character> PIPE = new Stack<>();
        int result = 0;
        //분할 된 쇠파이프 수 -> (         ) 사이에 () 수 +1
        // ex (    ()     ()      ) -> 파이프는 3등분
        // ex 2 [  [ () () ][ () ] () ]
        //레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 ‘( ) ’ 으로 표현된다. 또한, 모든 ‘( ) ’는 반드시 레이저를 표현한다.
        //쇠막대기의 왼쪽 끝은 여는 괄호 ‘ ( ’ 로, 오른쪽 끝은 닫힌 괄호 ‘) ’ 로 표현된다
        /*
        if현재문자열 ( && 다음문자열 ) -> 레이저cnt++
        반대로 생각
        ) 앞에 (면 레이저
        ) 앞에 )면 단순 파이프
         */

        for(int i = 0 ; i < line.length(); i++){
            if(line.charAt(i) == '('){ // ( 파이프 or 레이저의 시작, push하고 다음 단계로
                PIPE.push(line.charAt(i));
                continue;
            }else{ // )면  pop한다
                PIPE.pop();
                if(line.charAt(i-1) == '('){// 바로 앞 문자가 (이면 레이저 -> 현재 스택사이즈 == pipe 수가 2배가 되야함
                    result += PIPE.size();
                }else{ //레이저가 아니므로 일반 파이프 수
                    result++;
                }
            }

        }

        System.out.println(result);


    }
}