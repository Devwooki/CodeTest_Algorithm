import java.util.*;

// N/2의 포켓몬을 선택할 때, 가장 많은 종류의 포켓몬 선택해서 갯수 return
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int value : nums){
            set.add(value);
        }
        
        int max = nums.length/2;
        
        if(max > set.size()) return set.size();
        else return max;
        
    
    }

}