import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11655_ROT13_1 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        //ROT13 -> 알파벳을 13씩 밀어서 만든다.
        for(int i = 0 ; i<str.length() ; i++){
            char c = str.charAt(i);
            if( c >= 'A'&& c <= 'Z'){
                //대문자
//                if(c+13 > 90){
//                    sb.append((char)(c-13));
//                }else sb.append((char)(c+13));
                sb.append((char)((c-'A'+13)%26 + 'A'));

            }else if( c >='a' && c <= 'z') {
                //소문자
//                if(c+13 > 122){
//                    sb.append((char)(c-13));
//                }else sb.append((char)(c+13));
                sb.append((char)((c-'a'+13)%26 + 'a'));
            }else{
                sb.append(c);
            }
            //대문자 A 65  Z 90
            //소문자 a 97  z 122


        }
        System.out.println(sb);
    }
}