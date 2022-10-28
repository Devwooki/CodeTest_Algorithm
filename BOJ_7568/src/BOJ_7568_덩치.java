import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7568_덩치 {


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new  StringBuilder();
        int num = Integer.parseInt(br.readLine()); //첫 번째줄 읽어옴

        StringTokenizer st;
        String[] info;
        int[][] arr = new int[num][2];
        int[] rank = new int[num];

        for(int i = 0; i < num ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        //덩치는 몸무게 - index : 0, 키 - idx : 1 둘 다 커야 큰 덩치로 인정함
        //자신보다 덩치가 큰 사람이 K명 -> 덩치 등수 k+1
        for(int i = 0 ; i <  num ; i++){
            for(int j =0 ; j < num ; j++){
                if(i == j) continue;
                if(arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]){
                    rank[j]++;
                }

            }
        }


        for(int i = 0 ; i < num ; i++){
            sb.append(rank[i]+1).append(" ");
        }

        System.out.println(sb);
    }
}