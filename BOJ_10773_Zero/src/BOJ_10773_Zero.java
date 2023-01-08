import java.io.*;
import java.util.*;

public class BOJ_10773_Zero{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < N ; ++i){
            int x = Integer.parseInt(br.readLine());
            if(x == 0 && !stack.isEmpty()) stack.pop();
            else stack.push(x);
        }
        long result = 0 ;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        System.out.print(result);

    }
}