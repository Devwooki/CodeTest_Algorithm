import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class BOJ_2750_1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] result = new int[n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        //10989 번 풀이 - 입력값들은 10000보다 작거나 같은 자연수
        int[] count = new int[10001];
        for(int i = 0 ; i < n ; i++){
            count[arr[i]]++;
        }

        //counting 누적합 시작
        for(int i = 1 ; i < count.length ; i++){
            count[i] += count[i-1];
        }

        //counting배열의 각 값은 시작점-1 == 각 값에 대응되는 위치에 배정
        //arr[0] = 7 -> count[7]=2라 가정, result[6]에 7입력과 같은 방식으로 진행
        for(int i = n-1 ; i >= 0 ; i--){
            count[arr[i]]--;
            result[count[arr[i]]] = arr[i];
        }

        //정렬 출력
        for(int i = 0 ; i < result.length ; i++){
            System.out.println(result[i]);
        }


        //간략화
        //10989 번 풀이 - 입력값들은 10000보다 작거나 같은 자연수






        //선택 정렬
        /*
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0 ; i < n -1 ; i++){// 마지막 인덱스 직전까지 비교하면 됨
            for(int j = i+1 ; j < n ; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }*/

        //Arrays.sort 사용
        //Arrays.sort(arr);

        //counting sort 사용
        //첫줄의 개수 N의 범위 1<= N <= 1000, 이후 값은 절댓값 1000보다 작거나같음
        boolean[] counting = new boolean[2001]; // 중복 제거하니 t/f로 구분 및 0의 값은 index 1000
        for(int i = 0 ; i < n ; i++){
            counting[Integer.parseInt(br.readLine())+1000] = true;
        }
        for(int i = 0 ; i < 2001 ; i++){
            if(counting[i]) System.out.println(i-1000);
        }

        /*
        for(int i = 0 ; i < n ; i++){
            sb.append(arr[i]);
            sb.append("\n");
            System.out.println(arr[i]);
        }*/

        //System.out.println("sb : " + sb);
    }
}