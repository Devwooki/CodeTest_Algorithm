import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


//<>태그 사이에는 알파벳 소문자, 공백만 존재
//일단 문자열은 알파벳 소문자, 숫자로 존재,  연속하는 두단어는 공백처리
public class BOJ_17413_wordreverse2 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean isTag = false;
        Stack<Character> words = new Stack<>();
        String input = br.readLine();
        //태그 발견하면 isTag스택에 < 삽입 -> > 발견할 때 까지  continue;
        // > 발견하면 pop 하고 넘어감
        // 문자열 발견 -> " "까지 words.push()
        // " "이나 '<'도달 -> 다시 pop해서 문자열 뒤집기
        for(int i = 0; i < input.length() ; i++){
            //태그인지 확인
            if(input.charAt(i) == '<'){
                while(!words.isEmpty()){
                    sb.append(words.pop());
                }
                isTag = true;
                sb.append(input.charAt(i));
            }else if(input.charAt(i) == '>'){
                isTag = false;
                sb.append(input.charAt(i));
            }
            //태그면 정방향 삽입
            else if(isTag)
                sb.append(input.charAt(i));
            else{ //태그가 아니면 스택에 push 후 pop
                if(input.charAt(i) == ' '){
                    while(!words.isEmpty()){ //조건이 참이면 반복하는게 while문 헷갈리지 말자
                        sb.append(words.pop());
                    }
                    sb.append(input.charAt(i));
                }else{
                    words.push(input.charAt(i));
                }

            }
        }
        while(!words.isEmpty()){ //조건이 참이면 반복하는게 while문 헷갈리지 말자
            sb.append(words.pop());
        }
        System.out.println(sb);
    }
}