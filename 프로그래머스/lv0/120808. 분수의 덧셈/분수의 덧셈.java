class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int topNum = numer1*denom2 + numer2*denom1;
        int botNum = denom1*denom2;
        int gcd = 0;
        for(int i=1; i<=topNum; i++){
            if(topNum%i==0 && botNum%i==0){
                gcd = i;
            }
        }
        int[] answer = {(topNum/gcd),(botNum/gcd)};
        return answer;
    }
}