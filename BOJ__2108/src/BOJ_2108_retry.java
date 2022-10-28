import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class BOJ_2108_retry {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()); // 수의 갯수
        StringBuilder sb =new StringBuilder();

        //입력값 배열에 삽입
        int[] arr = new int[num];
        for(int i = 0 ; i < num ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        for(int i = 0 ; i < num ; i++){
            System.out.print(arr[i] + ", ");
        }

        //산술 평균
        double sum = 0;
        for(int i = 0 ; i<num ; i++){
            sum += arr[i];
        }
        sum = Math.round(sum/num);
        sb.append((int)sum).append("\n");

        //중앙값 출력
        sb.append(arr[num/2]).append("\n");

        // 최빈값 출력 - 여러개 있을 때 두 번째로 작은 값 출력
        HashMap<Integer, Integer> valueCount = new HashMap<Integer, Integer>();
        // 배열을 해쉬테이블로 변경, 중복발견시 값+1
        for(int v : arr) {
            if(valueCount.containsKey(v)){
                valueCount.put(v,valueCount.get(v)+1);
            }else{
                valueCount.put(v, 1);
            }
        }

        /*
        max : 빈도 수 가장 큰 값
        count : max 갯수
        MaxKey : 첫 번째 최빈 값
         */
        int max = 0;
        int maxCount = 0;
        int Maxkey = 0;

            //최빈값 발견
        for(int key : arr){
            if(max < valueCount.get(key)) {
                max = valueCount.get(key);
                Maxkey = key;
                maxCount = 1;
            }
        }
            //최빈값 여러개 있는지 판단
        for(int i = 0 ; i < num-1 ; i++){
            if(arr[i] == arr[i+1])continue; //정렬된 배열에서 현재idx 값과 다음값이 같으면 continue
            else{                           //다르면 해쉬 value 비교
                if(valueCount.get(arr[i])==valueCount.get(arr[i+1])){ //value가 같으면 둘의 최빈 값이 같음
                    if(maxCount==2) {
                        Maxkey=arr[i];//최빈값 여러개임, 이때 maxcount가 2개면 두 번째  최빈값이므로
                    }
                    maxCount++;
                }
            }
        }
        System.out.println("\n "+valueCount.entrySet() + ", max : " + max + ", count : " + maxCount
                + ", many : " + Maxkey);
        sb.append(Maxkey).append("\n");




        //범위 출력 : 최댓값 - 최솟값
        sb.append(arr[num-1]-arr[0]).append("\n");
        System.out.println(sb);
    } 

}