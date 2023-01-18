import java.io.*;
import java.util.*;

public class Main{
    public static String[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        arr = new String[TC];
        for(int i = 0 ; i < TC ; ++i){
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length())
                    return o1.compareTo(o2); //기존 방식인 사전 순 정렬
                else return o1.length() - o2.length();//길이에 따라 내림차순
            }
        });
        sb.append(arr[0]+"\n");
        for(int i = 1 ; i < TC ; ++i){
            if(arr[i].equals(arr[i-1]))continue;
            sb.append(arr[i]+"\n");
        }
        System.out.print(sb);

    }
}