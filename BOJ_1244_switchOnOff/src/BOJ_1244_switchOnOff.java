import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1244_switchOnOff {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder  sb = new StringBuilder();
        StringTokenizer st;
        //남학생 - 1 받은 수의 배수 상태 변경
        //여학생 - 2 받은 수를 중심으로 좌우 대칭이면서 가장 많은 스위치 구간상태 반전, 스위치 개수는 항상 홀 수
        int number = Integer.parseInt(br.readLine());
        int[] arr = new int[number+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= number ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int TC = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < TC ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int gender = Integer.parseInt(st.nextToken());
            int getCNT = Integer.parseInt(st.nextToken());

            if(gender == 1) { // gender 1 = 남자 -> getCNT 배수만큼 반전
                for(int j = getCNT ; j <= number ; j += getCNT){
                    //arr[j] =  (arr[j]==1) ? 0 : 1;
                    arr[j] ^= 1;
                }
            }else {
                int a = getCNT-1;
                int b = getCNT+1;
                while(1  <= a  &&  b <= number){ //스위치 범위 내에서 반복
                    if(arr[a] != arr[b]) break;
                    a--;
                    b++;
                }
                for(int j = a+1 ; j < b ; j++ ){
                    //arr[j] = (arr[j]==1) ? 0 : 1 ;
                    arr[j] ^= 1;
                }
            }
        }

        //20개 마다 \n 입력
        for(int i = 1  ; i <=number ; i++){
            sb.append(arr[i]).append(" ");
            if(i%20 == 0) sb.append("\n");
        }

        System.out.print(sb);
    }
}
