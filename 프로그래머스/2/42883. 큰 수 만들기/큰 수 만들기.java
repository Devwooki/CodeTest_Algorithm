import java.util.*;
class Solution {
    public String solution(String number, int k) {
        //k구간내에서 최대값들을 찾아서 이으면 가장 큰 값이 나온다.
        int size = number.length();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        
        for(int i = 0 ; i < size - k ; ++i){
            char max = 0;
            for(int j = idx ; j <= i + k ; ++j){
                char c = number.charAt(j);
                
                if( max < c){
                    max = c;
                    idx = j + 1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}