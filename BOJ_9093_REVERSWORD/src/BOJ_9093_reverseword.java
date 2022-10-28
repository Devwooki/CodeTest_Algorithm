import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9093_reverseword {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String[] strArr;
        for(int i = 0 ; i < TC ; i++){
            strArr = br.readLine().toString().split(" ");//문자열 입력받아  배열로 변경

            for(int j = 0 ; j < strArr.length; j++){
                int temp = strArr[j].length();
                for(int k = temp-1 ; k >= 0 ; k--){
                    sb.append(strArr[j].charAt(k));
                }
                sb.append(" ");
            }
            System.out.println(sb);
            sb.delete(0, sb.length()); // stringBuilder 객체 빈 문자열로 초기화
        }

    }
}