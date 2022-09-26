import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;


public class BOJ_2775 {
    final static int SIZE = 15;
    public static int[][] apt = new int[SIZE][SIZE];

    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        make_APT();
        int tc = Integer.parseInt(bf.readLine());
        for(int i = 0 ; i < tc ; i++){
            int  k = Integer.parseInt(bf.readLine());
            int  n = Integer.parseInt(bf.readLine());
            sb.append(apt[k][n]).append('\n');
        }
        System.out.println(sb);

        /*
        Scanner sc = new Scanner(System.in);

        int[][] apt = new  int[SIZE][SIZE];
        for(int i = 0; i < SIZE ; i++){
            apt[i][1] = 1;
            apt[0][i] = i;
        }
        for(int i = 1 ; i < SIZE ; i++ ){
            for(int j = 2 ; j < SIZE ; j++){
                apt[i][j] = apt[i][j-1] + apt[i-1][j];
            }
        }
        int tc = sc.nextInt();
        for(int i = 0 ; i < tc ; i++){
            int  k = sc.nextInt();
            int  n = sc.nextInt();
            System.out.println(apt[k][n]);
        }
        */
   }

   public static void make_APT(){
       //문제 조건 생성
       for(int i = 0; i < SIZE ; i++){
           apt[i][1] = 1;
           apt[0][i] = i;
       }
       for(int i = 1 ; i < SIZE ; i++ ){
           for(int j = 2 ; j < SIZE ; j++){
               apt[i][j] = apt[i][j-1] + apt[i-1][j];
           }
       }
   }
}