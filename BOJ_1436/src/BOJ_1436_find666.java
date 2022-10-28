import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1436_find666 {
    public static void main(String[] args)throws IOException {
        //brute force 방법
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int num = Integer.parseInt(br.readLine());
//        int cnt = 1;
//        int result = 666;
//        /*
//        문자열 -666이 들었는지 확인용+ long형 숫자 출력을 위해 사용
//         */
//        while(cnt!=num){
//            result++;
//            if(String.valueOf(result).contains("666"))cnt++;
//        }
//        System.out.println(result);


        //숫자에 666이 들어가는지 구간별 검사방법법
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        if(num == 1){
            System.out.println(666);
        }else{
            sium(num);
        }
    }

    public static void sium(int n){
        /*
         n = 10000 -> 2666799 즉 7자리
         보다 작으면서 7자리 하면 666_000, x66_600, xx6_660, xxx_666과 같이 4개로 쪼개기 가능
         */
        int cnt = 1;
        int result = 0;
        int pri_digit = 0; //4번째자리부터 출력하는 것
        while(true){
            if (((pri_digit % 10000) / 10) == 666 && pri_digit % 10 != 6) {
                for (int i = 0; i < 1000; i++) {
                    if (cnt == n) {
                        System.out.print(pri_digit * 1000 + result);
                        return;
                    }
                    result++;
                    cnt++;
                }
                pri_digit++;
            }
            else if(pri_digit % 1000 == 666){//x666_000인거 처리
                result = 0;
                for(int i = 0 ; i < 1000 ; i++){
                    if(cnt == n ){
                        System.out.println(pri_digit * 1000 +result);
                        return;
                    }
                    result++;
                    cnt++;
                }
                pri_digit++;
            }else if(pri_digit%100 == 66){//x66_600 처리
                result = 600;
                for(int i = 0 ; i < 100 ; i++){
                    if(cnt == n ){
                        System.out.println(pri_digit * 1000 +result);
                        return;
                    }
                    result++;
                    cnt++;
                }
                pri_digit++;
            }else if(pri_digit%10 == 6){//xx6_660 처리
                result = 660;
                for(int i = 0 ; i < 10 ; i++){
                    if(cnt == n ){
                        System.out.println(pri_digit * 1000 +result);
                        return;
                    }
                    result++;
                    cnt++;
                }
                pri_digit++;
            }else{//xxx_666처리
                result = 666;
                if(cnt == n ){
                    System.out.println(pri_digit * 1000 +result);
                    return;
                }
                cnt++;
                pri_digit++;
            }
        }
    }
}