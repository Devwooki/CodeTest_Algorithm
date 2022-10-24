import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1406_editor {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        StringBuilder sb = new StringBuilder();

        //왼쪽 스택에 문자열 입력함
        String firstLine =  br.readLine();
        for(int i = 0 ; i < firstLine.length() ; i++){
            left.push(firstLine.charAt(i));
        }

        int TC = Integer.parseInt(br.readLine());

        //명령어 수행횟수
        for(int i = 0 ;  i < TC ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String inputCMD = st.nextToken();

            switch (inputCMD.charAt(0)){
                case 'L' :  //커서왼쪽, 맨앞이면 무시
                    if(!left.isEmpty()){
                        right.push(left.pop());
                        //left.pop();
                    }
                    break;
                case 'D' : //커서오른쪽, 맨뒤면 무시
                    if(!right.isEmpty()) {
                        left.push(right.pop());
                        //right.pop();
                    }
                    break;
                case 'B' : //커서왼쪽 삭제,  맨앞이면 무시,
                    if(!left.isEmpty()){
                        left.pop();
                    }
                    break;
                case 'P' : // p뒤의 문자  추가
                    String mystr = st.nextToken();
                    left.push(mystr.charAt(0));
                    break;
            }
        }

        while(!right.isEmpty()){
            left.push(right.pop());
        }

        for(char c : left){
            sb.append(c);
            //System.out.print(c);
        }
        System.out.println(sb);
    }
}