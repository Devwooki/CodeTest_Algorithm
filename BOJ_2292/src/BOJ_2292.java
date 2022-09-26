import java.util.Scanner;

public class BOJ_2292 {
    public static void main(String[]  args){
        //LV별 방의 수 6n (n=1 = lv2)
        //누적 방의 수  3n(n+1)
        //마지막 계산에 +1 해주기
        Scanner in = new Scanner(System.in);

        int value = in.nextInt();
        int count = 1;
        int result;

        while (true) {
            result = 3 * count * (count + 1) + 1;
            //System.out.println("result : " + result + ", count :" + count + ",  value : " + value);
            if(value == 1){
                System.out.println(count);
                break;
            }
            else if (value > result) {
                count++;
                //System.out.println(count +1);
            }
            else{
                System.out.println(count+1);
                break;
            }

        }

    }
}