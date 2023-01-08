import java.io.*;
import java.util.*;

public class BOJ_2343_makeBlueRay{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //레슨 수
        int M = Integer.parseInt(st.nextToken()); //블루레이 수

        /*
        블루레이 개수를 맞출 수 있는 최소시간을 맞추는 문제
        -> 레슨 시간이 순서대로 입력됨,
        탐색 최솟값 : 가장 마지막 레슨(녹화는 레슨 중간에 끊을  수 없음)
        탐색 최댓값 : 모든 레슨의 합 -> 1개
         */
        int[] lesson = new int[N];
        int hi = 0;
        int lo = 0;
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < N ; ++i){
            lesson[i] = Integer.parseInt(st.nextToken());
            lo = Math.max(lo, lesson[i]);  //정렬하면 안되는 이유  ij사이의 레슨 모두  포함되어야 하기 ㄸ ㅐ문
            hi += lesson[i];
        }

        while( lo <= hi){
            //int mid = lo + ((hi-lo)/2);
            int mid = (lo +  hi)/2;
            int sum = 0;
            int cnt = 0;
            for(int i = 0 ;  i < N ; ++i){
                sum += lesson[i];
                if(sum > mid){ //합산 한 값이  mid를  넘어서면 새로운 sum을 구해야함
                    cnt++;
                    sum= lesson[i];
                }
            }

            if(sum != 0) cnt++;//sum아 0이 아니면 마지막 블루레이가 필요해서 cnt  증가


            if(cnt <= M){ //너무 적게 쪼개짐 hi 낮추기
                hi =  mid-1;
            }else  if(cnt > M) { //너무 잘게 쪼개짐  lo 증가
                lo = mid + 1;
            }
        }
        System.out.print(lo);

    }
}

//레슨 수업 초기화
//        int[] lesson = new int[N];
//        int end = 0;
//        st = new StringTokenizer(br.readLine(), " ");
//        for(int i = 0 ; i < N ; ++i){
//            lesson[i] = Integer.parseInt(st.nextToken());
//            end += lesson[i];
//        }
//        Arrays.sort(lesson);
//        int start = lesson[N-1];
//
//        while(start <= end){
//            int volume = (start+end)/2;
//            int sum = 0; //구간의 블루레이 영상 길이
//            int cnt = 0; //현재 사용한 블루레이 수
//            for(int i = 0 ; i < N ; ++i){
//                if(sum + lesson[i] > volume){
//                    cnt++;
//                    sum = 0;
//                }
//                sum += lesson[i];
//            }
//
//            if(sum != 0) cnt++;
//
//            if(cnt > M) start = volume +1;
//            else end = volume-1;
//        }