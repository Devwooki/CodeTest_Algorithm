import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2839 {

    public static void main(String[] args) throws IOException{
        //3과 5의 최소합
        //greedy 풀이이
       BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int kg = Integer.parseInt(st.nextToken());

        //greedy 풀이
        int count = 0;
        while(true){
            if(kg == 4 || kg == 7){
                count = -1;
                break;
            }else if(kg % 5 == 0){
                count += (kg/5);
                break;
            }
            else{
                kg -= 3;
                count++;
            }
        }
        System.out.println(count);
        //System.out.println("일반 계산 법"+myResult(kg));
    }

    //일반 풀이
    public static int myResult(int kg){

        if(kg == 4 || kg == 7){
            return -1;
        }
        else if((kg % 5) == 2 || (kg % 5) == 4){
            return (kg/5) + 2;
        }else if((kg % 5) ==0){
            return (kg/5);
        }
        else if((kg % 5) == 1 || (kg % 5) == 3){
            return (kg/5) +1;
        }
        return  0;
    }
}