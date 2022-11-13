import java.io.*;
import java.util.*;

public class BOJ_2309_7shortman{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] heights = new int[9];
        int sum = 0;
        for(int i = 0 ; i < 9 ; ++i){
            heights[i] = Integer.parseInt(br.readLine());
            sum += heights[i];
        }
        //특정 2명의 키만 빼면 100이 나옴
        Arrays.sort(heights);
        int fake1 = 0;
        int fake2 = 0;

        loopOut:
        for(int i = 0 ; i < 9 ; ++i){
            for(int j = i+1 ; j < 9 ; ++j){
                if(sum - (heights[i] + heights[j]) == 100){
                    fake1 = heights[i];
                    fake2 = heights[j];
                    break loopOut;
                }
            }
        }

        for(int i = 0 ; i < 9 ; i++){
            if(heights[i] == fake1 || heights[i] == fake2) continue;
            sb.append(heights[i] + "\n");
        }
//
//        loop1:
//        for(int a = 0 ; a < 3 ; ++a){
//            for(int b = a+1 ; b < 4 ; ++b){
//                for(int c = b+1 ; c < 5 ; ++c){
//                    for(int d = c+1 ; d < 6; ++d){
//                        for(int e = d+1  ; e < 7; ++e){
//                            for(int f = e+1  ; f < 8; ++f){
//                                for(int g = f+1  ; g < 9; ++g){
//                                    sum = heights[a] + heights[b] + heights[c] + heights[d] + heights[e] + heights[f] + heights[g];
//                                    if(sum == 100) {
//                                        result[0] = heights[a];
//                                        result[1] = heights[b];
//                                        result[2] = heights[c];
//                                        result[3] = heights[d];
//                                        result[4] = heights[e];
//                                        result[5] = heights[f];
//                                        result[6] = heights[g];
//                                        break loop1;
//                                    }
//                                    }
//                                    sum = 0;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//
//        Arrays.sort(result);
//        for(int i=0 ; i < 7 ; i++){
//            sb.append(result[i] + "\n");
//        }

        System.out.print(sb);
        }

   }

