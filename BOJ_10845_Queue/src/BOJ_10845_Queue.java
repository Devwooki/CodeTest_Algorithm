import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10845_Queue {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> qu = new LinkedList<>();
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int last = 0;
        for(int i = 0 ; i < TC ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();

            switch (cmd) {
                case "push" :
                    last = Integer.parseInt(st.nextToken());
                    qu.add(last);
                    break;
                case "pop" :
                    if(!qu.isEmpty())
                        System.out.println(qu.poll());
                    else
                        System.out.println(-1);
                    break;
                case "size" :
                    System.out.println(qu.size());
                    break;
                case "empty" :
                    if(qu.isEmpty())
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;
                case "front" :
                    if(qu.isEmpty()) System.out.println(-1);
                    else System.out.println(qu.peek());
                    break;
                case "back" :
                    if(qu.isEmpty()) System.out.println(-1);
                    else System.out.println(last);
                    break;
            }
        }
    }
}