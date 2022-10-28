import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BruteForce_1018_chessboard {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        //1. 인풋값 입력받음 라인 전체를 읽어온다
        String[] chessBoard = new String[M];
        for(int i = 0 ; i < M; i++){
            chessBoard[i] = br.readLine();
        }
        //2. 8 x 8크기로 자르기
        int result = Integer.MAX_VALUE;
        int prevValue = 0;
        for(int i = 0 ; i < M-7; i++){
            for(int j = 0 ; j < N-7; j++){
                prevValue = find(i, j, chessBoard);
                if(result > prevValue)  result = prevValue;  //최소값을 출력해야하므로
            }
        }
        System.out.println(result);
    }

    //3. 자른 것으로 연산 ㅅ ㅣ작
    public static int find(int partRow, int partCol, String[] board ){
        String[] orignPattern = {"WBWBWBWB","BWBWBWBW"};
        // 8*8 체스판은 다음과 같은 패턴의 반복으로 나타남

        int whiteCNT = 0;
        for(int i = 0 ; i < 8 ; i++){
            int row = partRow + i;
            for(int j = 0 ; j < 8 ; j++){
                int col = partCol + j;
                if(board[row].charAt(col) != orignPattern[row % 2].charAt(j))whiteCNT++;
            }
        }
        return Math.min(whiteCNT, 64-whiteCNT);
    }
}