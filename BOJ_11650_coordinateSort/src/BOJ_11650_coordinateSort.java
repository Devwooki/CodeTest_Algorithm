import java.io.*;
import java.util.*;

public class BOJ_11650_coordinateSort{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        int[][] arr = new int[TC][2];
        for(int i = 0 ; i < TC ; ++i){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] ==  o2[0])
                    return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });

        for(int i = 0 ; i < TC ; ++i){
            sb.append(arr[i][0] + " " + arr[i][1] +"\n");
        }

        System.out.print(sb);

    }
}