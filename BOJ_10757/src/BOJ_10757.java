import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class BOJ_10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        //BigInteger class 사용
        /*
        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());
        A = A.add(B);
        System.out.println(A.toString());
         */

        //직접 구현 - 배열로 해야함
        String strA = st.nextToken();
        String strB = st.nextToken();

        //두 문자 중 길이가 더 긴 것을 구함
        int max_len = Math.max(strA.length(), strB.length());;
        int[] A = new int[max_len + 1];
        int[] B = new int[max_len + 1];

        //A, B 초기화 정순으로 입력하면 안되는 이유 999 + 1 -> 999 + 100으로 입력됨
        for(int i = strA.length() -1, idx = 0 ; i >= 0 ; i--, idx++){
            A[idx] = strA.charAt(i) - '0'; //charAt 에서 -'0' 해주지 않으면 아스키 코드값인  49가 입력됨 따라서 빼줘야함
        }
        for(int i = strB.length() -1 , idx = 0 ; i >= 0 ; i--, idx++){
            B[idx] = strB.charAt(i) - '0';
        }

        //두 배열 더함
        for(int i = 0 ; i < max_len ; i++){
            int sum = A[i] + B[i];
            A[i] = sum % 10;
            A[i+1] += (sum / 10);
        }

        StringBuilder sb = new StringBuilder();
        //가장 높은 자리수의 배열이 0이 아닐 경우에 출력
        if(A[max_len] != 0) {
            sb.append(A[max_len]);
        }
        for(int i = max_len-1 ; i >= 0 ; i--){
            sb.append(A[i]);
        }

        System.out.println(sb);
    }
}