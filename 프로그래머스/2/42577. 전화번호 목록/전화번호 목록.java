import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        String  base = phone_book[0];
        for(int i = 1 ; i < phone_book.length ; ++i){
            if(phone_book[i].startsWith(base)) return false;
            else base = phone_book[i];
        }
        
        return true;
    }
}