import java.io.*;
import java.util.*;

public class BOJ_1920_findMyNum_binsch{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < N ; ++i){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < M ; ++i){
            int num = Integer.parseInt(st.nextToken());
            boolean find = false;
            int start = 0;
            int end = N-1;
            while(start<=end){ //찾거나, 시작값<= 계속 반복
                int m_idx = (start+end)/2;
                int m_value = A[m_idx];
                if(num < m_value){
                    end = m_idx-1;
                }else if(num > m_value){
                    start =  m_idx+1;
                }else{
                    find = true; //찾앗으므로
                    break;
                }
            }
            if(find) sb.append(1+"\n");
            else sb.append(0+"\n");
        }

        System.out.print(sb);

    }
}
