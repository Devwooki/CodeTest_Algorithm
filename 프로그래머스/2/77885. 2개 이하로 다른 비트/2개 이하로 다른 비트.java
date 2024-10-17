class Solution {
    public static long[] solution(long[] numbers) {

        int size = numbers.length;
        long[] answer = new long[size];
        for(int i = 0 ; i < size ; ++i){
            //짝수 : +1만 더해주면 된다(이진법에서 마지막 항만 홀수 이기 때문)
            if(numbers[i] % 2 == 0){
                answer[i] = numbers[i] + 1;
            }else{
                String binStr = Long.toBinaryString(numbers[i]);

                int findIndex = binStr.lastIndexOf("01");
                if(findIndex == -1){
                    int tobinLen = binStr.length();
                    String bigMinNo = "10" + binStr.substring(1, tobinLen);
                    
                    answer[i] = Long.parseLong(bigMinNo, 2);

                }else{
                    binStr = binStr.substring(0, findIndex) 
                        + "10" 
                        + binStr.substring(findIndex+2);
                
                    answer[i] = Long.parseLong(binStr, 2);
                }
            }
        }
        return answer;
    }
}