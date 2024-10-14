import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        int SIZE = numbers.length;
        int idx = 0;
        int[] answer = new int[SIZE];
        
        //배열 초기화
        Arrays.fill(answer, -1);
        
        //스택의 역할 : 보다 큰 수를 찾지 못했을 때 저장하는 통
        /*
        1. i = 0,스택에 i(2) 넣음
        2. i = 1, numbers[peek] = 2, numbers[i] = 3 
           pop한 값은 0임,의 오큰수는 3 -> 
           answer[pop] = numbers[i]; //이때 스택은 비어있지 않기에 pop 가능
          
            i의 오큰수를 구해야하니, stack에 넣는다.
            stack.push(i)
        
        3. i = 2, numbers[peek(1)] = 3, numbers[i] = 3
            pop한 값은 1임, 오큰수가 아님 stack에 push
            
        4. i = 3, numbers[peek(2)] = 3, numbers[i] = 5
            pop한 값은 2 -> numbers[pop] <numbers[i] = 5
            answer[pop] = numbers[i];
            스택에 2가 남아있음
            
            while문 시작
            4-1. stack.pop=2, numbers[pop] = 3, 
                answer[pop] = numbers[i];
          
        */
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i <SIZE ; ++i){
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        
        return answer;
    }
}