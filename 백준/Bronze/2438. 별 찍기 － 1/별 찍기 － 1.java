import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		int N = in.nextInt();
		in.close();
       for (int i = 1; i <= N; i++) {
            sb.append("*".repeat(i) + "\n");
        }
       
        System.out.println(sb);
	}
}