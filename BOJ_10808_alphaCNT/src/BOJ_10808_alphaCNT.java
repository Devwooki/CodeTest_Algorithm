import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10808_alphaCNT {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int[] arr = new int[26];

        for(int i = 0 ; i < str.length() ; i++){
            char c = str.charAt(i);
            if(c >=  97 && c <=123) arr[c-'a']++;
        }
        for(int k : arr){
            sb.append(k).append(" ");
        }
        System.out.println(sb);
    }
}