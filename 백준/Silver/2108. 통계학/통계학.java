import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;
        for(int i = 0 ; i < N ; ++i){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);
        //평균
        sb.append((int)Math.round((double)sum/N)+"\n");

        //중앙값
        int mid = N/2;
        sb.append(arr[mid]+"\n");

        //최빈값
        int[] counting = new int[8001];//  -4000~4000까지
        int start = arr[0];
        int end =  arr[N-1];
        for(int i = 0 ; i < N ; ++i){
            counting[4000+arr[i]]++;
        }
        int max = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = start ; i <= end ; i++){
            max = Math.max(max, counting[4000+i]);
        }
        for(int i = start ; i <= end ; i++){
            if(counting[4000+i]== max){
                list.add(i);
            }
        }
        if(list.size() > 1){
            sb.append(list.get(1) + "\n");
        }else sb.append(list.get(0) + "\n");

        //범위
        sb.append(arr[N-1]-arr[0]+"\n");
        System.out.print(sb);

    }
}