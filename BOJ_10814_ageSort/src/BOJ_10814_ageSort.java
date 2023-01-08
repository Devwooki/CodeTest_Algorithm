//import java.io.*;
//import java.util.*;
//
//public class BOJ_10814_ageSort{
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();
//        int N = Integer.parseInt(br.readLine());
//        String[][] arr = new String[N][2];
//        for(int i = 0 ; i<N ;++i){
//            st = new StringTokenizer(br.readLine()," ");
//            arr[i][0] = st.nextToken();
//            arr[i][1] = st.nextToken();
//        }
//
//        Arrays.sort(arr, new Comparator<String[]>() {
//            @Override
//            public int compare(String[] o1, String[] o2) {
//                return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
//            }
//        });
//
//        for(int i = 0 ; i<N ;++i){
//            sb.append(arr[i][0] +" " + arr[i][1]+"\n");
//        }
//        System.out.print(sb);
//
//    }
//}
import java.io.*;
import java.util.*;

public class BOJ_10814_ageSort{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringBuilder[] arr = new StringBuilder[201];//나이가 200살까지 존재한다 했으므로
        //객체배열의 인덱스에 각 StringBuilder 객체를 생성해준다.
        for(int i = 0; i < arr.length; i++) {
            arr[i] = new StringBuilder();
        }

        for(int i = 0 ; i<N ;++i){
            st = new StringTokenizer(br.readLine()," ");
            int age = Integer.parseInt(st.nextToken());
            String name =  st.nextToken();
            //카운팅 정렬 : 나이를 index로 하여  배열에 나이와 이름ㅇ르 붙임
            arr[age].append(age+" "+name +"\n");  //같은 나이일 경우 문자열뒤에 append 해서 입력순으로 불러올 수 있음
        }


        for(StringBuilder val : arr){
            sb.append(val);
        }
        System.out.print(sb);

    }
}
