import java.util.Scanner;

public class BOJ_1193 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int value = in.nextInt();
        int count = 0;

        while(true){
            value -= count;
            count++;
            if(value <= count)
                break;
        };
        if (count%2==1)
            System.out.println((count+1)-value + "/" +value);
        else
            System.out.println(value + "/" + ((count+1)-value));
    }
}