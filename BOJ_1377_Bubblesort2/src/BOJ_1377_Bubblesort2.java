import java.io.*;
import java.util.*;
//입력값  최대가 500,000인데 버블정렬시 시간 초과
// -> 버블sort의 원리를 이용해 결과도출
class mData implements Comparable<mData>{
    public int index;
    public int value;

    public mData(int value, int index){
        super();
        this.value =  value;
        this.index = index;
    }

    @Override
    //value를 비교한게 우선순위
    public int compareTo(mData o){
        return this.value - o.value;
    }


}


public class BOJ_1377_Bubblesort2{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        mData[] A = new mData[N];

        //mData클래스에 값과 index 삽입
        for(int i = 0 ; i < N ; ++i){
            A[i] = new mData(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(A);// A 배열 정렬 ( O(nlogN) 복잡도로 정렬
        //버블 정렬 1cycle에 각 원소별로 앞으로 1칸 이동이 가능하지만 뒤로는 무한히 발생 가능
        // -> 앞칸으로 이동한 것들 중 최대값이 bubble sort 사이클 횟수
        // 정렬후 mData[i]와 mdata[i].index의 차이 구하기
        // 앞으로 이동( +)로 표시 뒤로이동(-)로 표시

        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < N ; ++i){
            max = Math.max(max, (A[i].index-i));    //이동한 횟수 - 1번
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max+1); //이동한 횟수 -1 이니 +1 시켜 원상복구
        System.out.print(sb);
    }
}

