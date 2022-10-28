import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Arrays;
//현재 인덱스의 값보다 작은 갯수 출력
// 2중 for문 -> O(n^2)
// map 사용 O(n) 이라 ㅎ ㅐ결 O
public class BOJ_18870 {
    public static void main(String[] args) throws IOException{
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> ranking = new HashMap<Integer, Integer>();

        int num = Integer.parseInt(br.readLine());
        int[] origin_arr = new int[num];
        int[] sorted_arr = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < num ; i++){
            sorted_arr[i] = origin_arr[i] = Integer.parseInt(st.nextToken());
        }

        //배열 정렬
        Arrays.sort(sorted_arr);
        //sorted_arr = Arrays.stream(sorted_arr).distinct().toArray();
        //오름차순 정렬된 배열에 랭크를 매김
        int rank = 0;
        for(int v : sorted_arr){
            //이때 원소가 중복되면 안되므로 조건문을 걸어줌
            if(!ranking.containsKey(v)) {
                ranking.put(v, rank);
                rank++;
            }
        }
        //기존 배열 원소(key)에 대한 value(rank를 가져옴)
        StringBuilder sb = new StringBuilder();
        for(int key : origin_arr){
            int count = ranking.get(key);
            sb.append(count).append(" ");
        }
        System.out.println(sb);
        */

        //입력값 원본 배열, 입력값 정렬 배열 생성
        //정렬된 배열로 해쉬 테이블 생성 -> 해쉬
        //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] origin = new int[num];
        int[] sorted = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < num ; i++){
            sorted[i] = origin[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        HashMap<Integer, Integer> rank = new HashMap<Integer, Integer>();
        int count = 0;
        for(int v : sorted){
            if(!rank.containsKey(v)) {//sorted배열에서 중복 값이 있으면 걸러냄
                rank.put(v, count);
                count++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int key : origin){
            sb.append(rank.get(key)).append(" ");
        }
        System.out.println(sb);
        }
}