import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_11653 {
    /*public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int div_value = 2;
        while(true){
            if(number % div_value == 0){
                number /=div_value;
                System.out.println(div_value);
            }else if(div_value > number){
                break;
            }else{
                div_value++;
                continue;
            }

        }
    }*/


    //시간 복잡도 개선 및 코드 변경
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int div_value = 2;
        while(number>1){
            if(number % div_value == 0){
                number /=div_value;
                System.out.println(div_value);
            }else{
                div_value++;
            }

        }
    }
}