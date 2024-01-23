import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int lastAtkTime = attacks[attacks.length-1][0];
        
        int healCnt = 0;
        int atkIdx = 0;
        
        int healTime = bandage[0];
        int dotValue = bandage[1];
        int additionalHeal = bandage[2];
        
        for(int i = 0 ; i <= lastAtkTime ; i++){
            if(i == attacks[atkIdx][0]){ //공격 시간과 같으면 피깜
                healCnt = 0; //회복 멈춤
                
                health -= attacks[atkIdx][1];
                if(health <= 0) return -1;
                
                atkIdx+=1;
            }else{ //회복
                health += dotValue;
                healCnt++;
                    
                if(healCnt == healTime){
                    health += additionalHeal;
                    healCnt = 0;
                }
                
                if(health >= maxHealth) health = maxHealth;                
            }
            //System.out.println(health);
        }
        
        
    
        return health;
    }
}