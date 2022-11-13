

import java.io.*;
import java.util.*;

public class BOJ_2527_squre{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int i = 1 ; i <= 4 ; ++i){
            st = new StringTokenizer(br.readLine()," ");
            int s1x1 = Integer.parseInt(st.nextToken());
            int s1y1 = Integer.parseInt(st.nextToken());
            int s1x2 = Integer.parseInt(st.nextToken());
            int s1y2 = Integer.parseInt(st.nextToken());

            int s2x1 = Integer.parseInt(st.nextToken());
            int s2y1 = Integer.parseInt(st.nextToken());
            int s2x2 = Integer.parseInt(st.nextToken());
            int s2y2 = Integer.parseInt(st.nextToken());
            /*
            선분 겹칠 때 : 네모1 y1좌표 == 네모2 y2좌표 || 네모1 y2좌표 == 네모2 y1좌표
                        네모1 x1좌표 == 네모2 x2좌표 || 네모1 x2좌표 == 네모2 x1좌표

            점이 겹칠 때 : 네모1 x1 y1 == 네모2 x2 y2 || 네모1 x1 y2 == 네모2 x2 y1
                        네모1 x2 y2 = 네모2 x1 y1 || 네모1 x2 y1 = 네모2 x1 y2

            공통 부분 없을 때 : 네모1 x2 < 네모2 x1 || 네모1 y2 < 네모2 y1
                            	|| 네모1 x1 > 네모2 x2 || 네모1 y1 > 네모2 y2
            else a
             */

            //선분 겹칠 때
            if(s1y1 == s2y2 ||s1y2 == s2y1 || s1x1 == s2x2 || s1x2 == s2x1){
                sb.append("b\n");
            //점 겹칠 때
            } else  if((s1x1 ==s2x2 && s1y1 == s2y2) //o
                    || (s1x1 ==s2x2 && s1y2 == s2y1) //
                    || (s1x2 == s2x1 && s1y1 == s2y2)
                    || (s1x2 == s2x1 && s1y2 == s2y1)){
                sb.append("c\n");
            //두 직사각형 분리 된 경우
            } else  if(s1x2 < s2x1
                    || s1y2 < s2y1
                    ||s1x1 >  s2x2
                    || s1y1 >  s2y2){
                sb.append("d\n");
            }else{
                sb.append("a\n");
            }
        }
        System.out.print(sb);

    }
}