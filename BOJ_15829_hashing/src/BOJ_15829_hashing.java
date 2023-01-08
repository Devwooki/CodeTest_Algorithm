import java.io.*;

public class BOJ_15829_hashing {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        System.out.println(myHash(str,L));

    }
    public static long myHash(String str, int L){
        long pow = 1;
        long MOD = 1234567891;

        long HashData = 0;
        for(int i = 0 ;  i < L ; ++i){
            //R을 제곱하다보면 오버플로우가  발생할 수 있기 때문에 분배법칙 적용
            //ar^N MOD M =( a MOD M * r^N MOD M) mod M
            HashData += (str.charAt(i) - 96)  * pow % MOD;
            pow = pow * 31 % MOD;
        }
        HashData %= 1234567891;
        return HashData;
    }
}