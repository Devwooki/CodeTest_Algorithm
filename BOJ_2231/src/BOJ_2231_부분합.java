//import java.io.IOException;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class BOJ_2231_부분합 {
//    //가장작은 생성자를 만드는 프로그램
//
//
//    public static void main(String[] args)throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str_num = br.readLine();
//
//        int divSum = Integer.parseInt(str_num);//분해합
//        int num_length = str_num.length();  //자릿 수
//        boolean has_creator = false;
//        int creator = 0;
//        for(int i = divSum - (num_length * 9) ; i <  divSum ; i++){
//            int N = i;
//            int sum = 0;
//
//            //값 비교 할 때
//            while (N != 0) {
//                sum = sum + N%10;
//                N /= 10;
//                //N = 12345 -> 5가 sum에 더해짐, n / 10 -> 1234 ,,, 1234%10 -> 4 더해지고... 각 자릿수의 합 = sum
//            }
//
//            if(sum + i == divSum) { //각자릿수의합(sum) + i == divSum
//                has_creator = true;
//                creator = i;
//                break;
//            }
//        }
//
//        if(has_creator) System.out.println(creator);
//        else System.out.println(0);
//
//        //216 = 198 + 1 + 9 + 8, 216 = 207 + 2 + 0 + 7
//        // 생성자 중 가장 작은거
//        // 생성자 없으면 0 -> 적어도 1개 이상
//
//        /*
//        step 1 : number의 자릿 수 구하기 while(number!=0)
//        step 2 : 수치 구하기
//             분해합은 생성자와 각 자릿수를 모두 더한 것, 각 자리숫를 더한 수는 큰값이 아님을 염두
//             -> 12345라는 5자리 숫자, 각 자리별 최댓값은 9 => 4*5 = 45를 뺴주여함 -> 12300 ~ 12345
//        step 3 : 값을 비교?*/
//
//    }
//}

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2231_부분합 {
    //가장작은 생성자를 만드는 프로그램


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str_num = br.readLine();

        int divSum = Integer.parseInt(str_num);//분해합
        int num_length = str_num.length();  //자릿 수
        boolean has_creator = false;
        int result = 0;
        for(int i = divSum - (num_length * 9) ; i <  divSum ; i++){
            int N = i;
            int sum = 0;//자릿수의 합
            while(N!=0){
                sum += N%10;
                N /= 10;
            }

            if((sum + i) == divSum){
                has_creator =  true;
                result = i;
                break;
            }
        }

        if(has_creator){
            System.out.println(result);
        }else{
            System.out.println(0);
        }

    }
}