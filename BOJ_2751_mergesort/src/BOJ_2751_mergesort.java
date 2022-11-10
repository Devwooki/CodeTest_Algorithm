import java.io.*;
import java.util.*;

public class BOJ_2751_mergesort{
    //병합 정렬의 base는 투포인터와  분할정복 알고리즘
    // 데이터를 비교하면서  찾기 때문에 비교졍렬/ 추가적인 공간을 필요로해  제자리 정렬이 아님
    // 안정정렬 알고리즘, 다만 구현시 2개의 부분리스트로 나누어야 하는 것은 아님,  2방식이 무난할 뿐
    public static int[] arr;
    public static int[] sorted; //정렬값을 저장할 배열
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sorted = new int[N];
        //입력값 저장
        for(int i = 0; i < N ; ++i){
            arr[i] =Integer.parseInt(br.readLine());
        }
        merge_sort(0, N-1);

        for(int i = 0; i < N ; ++i){
            sb.append(sorted[i] + "\n");
        }
        System.out.print(sb);

    }

    /*
    @param s : start
    @param e : end
     */
    public static void merge_sort(int s, int e){
        if(e==s) return; // 부분리스트가 1개인 원소를 더 이상 쪼갤 수 없어  return
        int m = (s+e)/2; //절반 위치 구함

        //재귀함수 형태로 풀이
        merge_sort(s, m);// 왼쪽  부분리스트
        merge_sort(m+1, e); //오른쪽 부분 리스트

        //sorted 배열에 arr복사, arr에 정렬값을 저장할 것임
        int k = s; //원본 배열 시작지점
        int l = s; // 그룹 1 시작지점
        int r = m+1; // 그룹 2 시작지점

        //두 그룹을 비교해 값이 작은 것을 배열에 저장, indexn증가,
        while(l <= m && r <= e){
            if(arr[l] <= arr[r]) { // 반복문 끝나면 남은 데이터 정리
                sorted[k] = arr[l];
                l++;
                k++;
            }else{
                sorted[k] = arr[r];
                r++;
                k++;
            }
        }

        /*
        왼쪽 부분 리스트가 sorted에 다채워지면 (l>mid) ->  오른쪽 부분리스트가  남아 있으므로 오른쪽거 배열에 채워줌
         */
        if(s > m){
            while(r <= e ){
                sorted[k] = arr[r];
                k++;
                r++;
            }
        }
        else{
            while(l <= m ){
                sorted[k] = arr[l];
                l++;
                k++;
            }
        }
    }
}