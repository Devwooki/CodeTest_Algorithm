import java.util.*;

class Solution{
    public int solution(String s){
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
                continue;
            }
            stack.push(c);
            
        }
        
        

        return stack.size() == 0 ? 1 : 0;
    }
}