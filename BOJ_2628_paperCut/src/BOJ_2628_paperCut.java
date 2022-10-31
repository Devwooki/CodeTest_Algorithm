import java.io.*;
import java.util.*;

//가로 세로 길이, 잘라야할 점선들이 주어질 때 가장 큰 종이 조각의 넓이
public class BOJ_2628_paperCut {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int max_r = Integer.MIN_VALUE;
        int max_c = Integer.MIN_VALUE;
        //자를 횟수 범위가 지정되지 않아 가변적인 arraylist 활용
        ArrayList<Integer> row = new ArrayList<>();
        row.add(0);
        ArrayList<Integer> col = new ArrayList<>();
        col.add(0);
        int width = Integer.parseInt(st.nextToken());   //가로
        row.add(width);
        int height = Integer.parseInt(st.nextToken());  //세로
        col.add(height);

        int TC = Integer.parseInt(br.readLine());  //점선 수
        for(int i = 0 ; i <  TC ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int isRC = Integer.parseInt(st.nextToken()); // 이것은 가로(row), 세로(col)인가 0 -> 가로, 1 세로
            int point = Integer.parseInt(st.nextToken());

            switch(isRC) {
                case 0 : col.add(point);  break;
                case 1 : row.add(point);  break;
            }
        }
        //각 배열 정렬
        Collections.sort(row);
        Collections.sort(col);

        for(int i = 0 ; i < row.size()-1 ; i++){
            if((row.get(i+1)-row.get(i)) > max_r) max_r = (row.get(i+1)-row.get(i));
        }
        for(int i = 0 ; i < col.size()-1 ; i++){
            if((col.get(i+1)-col.get(i)) > max_c) max_c = (col.get(i+1)-col.get(i));
        }

        System.out.println(max_c * max_r);
    }
}
/*
풀이 방법
시작은 0, 가로세로 길이는 width, height
잘랐을 때 가장 긴 값으로 곱하면 가장 큰 넓이
ex) 길이10, 3에서 자른다고 하면 가로길이는 3, 7로 나뉘고
    세로8,  2와 5에서 자를시 2, 3, 3이므로 3이 가장 큼
 */