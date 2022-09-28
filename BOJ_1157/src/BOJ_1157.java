import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String in = br.readLine();
        in = in.toUpperCase();
        int[] alphabet = new int[26];
        int  max= -1;
        char ch = 0;

        //입력 문자열 끝까지 반복하여 갯수 증가
        for(int i = 0 ; i<in.length() ; i++){
            alphabet[in.charAt(i)-65]++;
            //아스키 코드 65 : A, 97 : a임을 기억
        }

        for(int i = 0 ; i < 26 ; i++) {
            if (max < alphabet[i]){
                max = alphabet[i];
                ch = (char)(65 + i);
                //ch =
            }else if(max ==  alphabet[i]){
                ch = '?';
            }
        }
        System.out.println(ch);
        //대소문자 구분하지 않고 대문자로 출력하므로 upper 사용

    }
}