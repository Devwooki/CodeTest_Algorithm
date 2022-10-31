import java.io.*;
import java.util.ArrayList;

public class BOJ_2635_SquenceNum {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int first = Integer.parseInt(br.readLine());
        int max_len = Integer.MIN_VALUE;
        ArrayList<Integer> result = new ArrayList<>();
        // arr[i] = arr[i-2] + a[i-1] , arr[i]>0, i>2
        /*
        두 번째 수가  first/2 미만이면 리스트 길이가 3개 미만으로 조기 종료됨
        ex) fist = 100, second = 49 -> 100, 49. 51 ?
        ex2) first = 100, snd = 1 -> 100, 1, 99 ?
         */
        for(int i = first; i >= first / 2 ; i--){
            ArrayList<Integer> now = new ArrayList<>();
            now.add(first);
            now.add(i);
            int front = first;
            int back = i;
            while(true){
                int temp = front - back;

                if(temp < 0) break;
                else{
                    now.add(temp);
                    front = back;
                    back = temp;
                }
            }

            if(now.size() > max_len){
                max_len = now.size();
                result = now;
            }
        }

        sb.append(result.size()).append("\n");
        for(int num : result) sb.append(num).append(" ");

        System.out.print(sb);
    }
}
