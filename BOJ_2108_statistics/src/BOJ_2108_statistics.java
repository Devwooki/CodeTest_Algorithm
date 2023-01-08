import java.io.*;
import java.util.*;

public class BOJ_2108_statistics{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        int[] arr = new int[TC];
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0 ; i < TC ; ++i){
            arr[i] = Integer.parseInt(br.readLine());
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            sum += arr[i];
        }
        //평균
        sb.append((int)Math.round((double)sum/TC)+"\n");

        //중앙값
        Arrays.sort(arr);
        int mid = TC/2;
        sb.append(arr[mid]+"\n");

        //최빈값
        int max = Collections.max(map.values());
        ArrayList<Integer> list_max = new ArrayList<>();
        for(HashMap.Entry<Integer, Integer> a : map.entrySet()){ //map.Entry(Key, Value)는 해당 map의 key와 value를 가지는 set객체 반환
            if(a.getValue() == max) list_max.add(a.getKey());
        }

        if(list_max.size() >= 1)
            sb.append(list_max.get(1)+"\n");
        else
            sb.append(list_max.get(0)+"\n");

        //범위
        sb.append(arr[TC-1]-arr[0]+"\n");
        System.out.print(sb);

    }
}