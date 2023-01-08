import java.io.*;
import java.util.*;

public class BOJ_1085_escapeSquare{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int result = Math.min(Math.min(Math.abs(h-y), Math.abs(0-y)),Math.min(Math.abs(w-x), Math.abs(0-x)));
        System.out.print(result);

    }
}