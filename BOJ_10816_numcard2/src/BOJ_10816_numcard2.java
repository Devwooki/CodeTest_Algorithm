//import java.io.*;
//import java.util.*;
////Hash를 이용해 푸는 방법
//public class BOJ_10816_numcard2{
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st;
//        int N = Integer.parseInt(br.readLine());
//        HashMap<Integer, Integer> map =  new HashMap<>();
//        st = new StringTokenizer(br.readLine()," ");
//        for(int i = 0 ; i < N ; ++i){
//            int x = Integer.parseInt(st.nextToken());
//            if(map.containsKey(x)){
//                map.replace(x, map.get(x)+1);
//            }else map.put(x,1);
//
//
//        }
//
//        int M = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine()," ");
//        for(int i = 0 ; i<M ;  ++i){
//            int y =  Integer.parseInt(st.nextToken());
//            if(map.get(y) == null) sb.append(0+" ");
//            else sb.append(map.get(y)+" ");
//        }
//        System.out.print(sb);
//    }
//}

import java.io.*;
        import java.util.*;

public class BOJ_10816_numcard2{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < N ; ++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        /*
        mid는 통상 lo+hi/2이지만 hi=Integer.MAX_VALUE;일 때 오버플로우가 발생
        -> lo~hi사이의 거리/2가 mid인 경우도 있음
        따라서 mid =  lo + ((hi-lo)/2)로 사용하면 중간 값을 구할 수 있음
         */


        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i<M ;  ++i){
            int key =  Integer.parseInt(st.nextToken());
            sb.append(upper(arr,key)-lower(arr,key)+" ");
        }
        System.out.print(sb);
    }
    public static int lower(int[] arr, int key){
        int lo = 0;
        int hi = arr.length;
        while(lo < hi){
            int mid = lo + ((hi-lo)/2);
            /*
            key 값이 중간 위치값보다 작거나 같을 때 상계를 내림
             */
            if(key <= arr[mid]){
                hi = mid;
            }else{
                lo = mid+1;
            }
        }
        return lo;
    }
    public static int upper(int[] arr, int key){
        int lo = 0;
        int hi = arr.length;
        while(lo < hi){
            int mid = lo + ((hi-lo)/2);
            /*
            key 값이 중간 위치값보다 작거나 같을 때 상계를 내림
             */
            if(key < arr[mid]){
                hi = mid;
            }else{
                lo = mid+1;
            }
        }
        return lo;
    }
}