import java.io.*;
import java.util.*;

public class BOJ_11478_otherwords{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        HashMap<String, Integer> hash = new HashMap<>();
        for(int i = 1 ; i <= str.length() ; ++i){ //부분 문자열 길이
            for(int j = 0 ; j <= str.length()-i ; ++j){//탐색 범위
                String temp = str.substring(j, j+i);
                hash.put(temp,1);
            }
        }


        System.out.print(hash.size());

    }
}
