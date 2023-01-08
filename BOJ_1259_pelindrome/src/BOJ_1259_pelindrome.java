import java.io.*;
import java.util.*;

public class BOJ_1259_pelindrome{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(true){
            String str = br.readLine();
            boolean isSame = true;
            if(str.equals("0")) break;
            int mid = str.length()/2;
            for(int i = 0 ; i < mid ;++i){ //글자 수 홀수면 비교 안해도 됨
                if(str.charAt(i) != str.charAt((str.length())-1-i)){
                    isSame = false;
                    break;
                }
            }

            if(isSame)
                sb.append("yes\n");
            else sb.append("no\n");

        }
        System.out.print(sb);

    }
}