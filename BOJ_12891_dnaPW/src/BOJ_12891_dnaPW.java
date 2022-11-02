import java.io.*;
import java.util.*;

public class BOJ_12891_dnaPW{
    static int[] ACGT;
    static int[] partACGT;
    static int isSame;
    public static void main(String[] args) throws IOException{

        int result = 0;
        //Dna 문자열 = ACGT, 각문자가 n개 이상  등장해야 비밀번호가 사용가능함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Math.abs(Integer.parseInt(st.nextToken())); //  dna 문자열 길이
        int P = Math.abs(Integer.parseInt(st.nextToken())); // 부분 문자열 길이
        String DNA = br.readLine(); // dna 문자열

        ACGT = new int[4]; // A C G T 등장 횟수
        partACGT = new int[4]; //부분 문자열에서  ACGT등장 횟수

        //초기 데이터 비교
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < 4 ; ++i){
            ACGT[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0 ; i < P ; ++i){
            char c = DNA.charAt(i);
            add(c);//add에서 ACGT와 partACGT 비교함
        }
        check();
        if(isSame==4) result++;


        //슬라이딩 적용
        for(int i = P ; i < S ; i++){
            isSame=0;
            int j = i-P;
            char front = DNA.charAt(j);
            char back = DNA.charAt(i);
            add(back);
            minus(front);
            check();
            if(isSame == 4) result++;
        }
        System.out.println(result);
    }

    public static void add(char a){
        switch(a){
            case 'A' :partACGT[0]++;break;
            case 'C' :partACGT[1]++;break;
            case 'G' : partACGT[2]++;break;
            case 'T' : partACGT[3]++;break;
        }
    }
    public static  void minus(char a){
        switch(a){
            case 'A' :partACGT[0]--;break;
            case 'C' :partACGT[1]--;break;
            case 'G' : partACGT[2]--;break;
            case 'T' : partACGT[3]--;break;
        }
    }
    public static void check(){
        for(int i = 0 ; i < 4 ; i++){
            if(ACGT[i] <= partACGT[i]) isSame++;
        }
    }
}