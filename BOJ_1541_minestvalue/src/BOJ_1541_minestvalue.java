import java.io.*;
import java.util.*;

public class BOJ_1541_minestvalue{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        /* 수식에서 최솟값 만들기
        -> 뺄 때 최댓값을 빼야함
        - 등장 -> -가 다시 등장할 때 까지 빼야함
         */
        String[] arr = str.split("-");
        int answer = 0;
        for(int i = 0 ; i < arr.length ; ++i){
            String[] temp = arr[i].split("[+]");
            int sum = 0;
            for(int j = 0 ; j < temp .length ; ++j){
                sum += Integer.parseInt(String.valueOf(temp[j]));
            }

            if(i == 0 )
                answer = sum;
            else
                answer -= sum;
        }
        System.out.println(answer);
    }
}

//        ArrayList<Integer> number = new ArrayList<>(); //숫자 저장할 ArrayList
//        ArrayList<Character> symbol = new ArrayList<>(); // +- 저장할 ArrayList
//        for(int i = 0 ; i < str.length() ; ++i ){
//            char c = str.charAt(i);//문자 글자씩 읽어옴
//            if(c == '+' || c == '-'){//심볼이 등장하면
//                symbol.add(c);//심볼 추가
//                number.add(Integer.parseInt(String.valueOf(sb)));//지금까지 누적한  str 숫자로 변환
//                sb = new StringBuilder(); //sb초기화
//            }else{
//                sb.append(c); //+, -가 아니면 계속 누적
//            }
//
//        }
//        number.add(Integer.parseInt(String.valueOf(sb))); //마지막꺼 배열에 추가
//
//
//        int result = number.get(0);
//        boolean flag = false;
//        int temp = 0;
//        for(int i = 0 ; i < symbol.size(); ++i){
//            char c = symbol.get(i);
//            if(c == '-'){
//                if(!flag){
//                    flag = true;
//                }
//            }
//
//            if(flag){
//                result -= number.get(i+1);
//            }else{
//                result += number.get(i+1);
//            }
//        }
//        System.out.print(result);