class Solution {
    public int solution(int[] common) {
        // 등차수열인지 확인 -> 아니면 등비수열
        int answer = 0;
        if((common[0]-common[1])==(common[1]-common[2])) {
            answer = common[common.length-1] + (common[common.length-1] - common[common.length-2]);
        }
        else answer = common[common.length-1] * (common[common.length-1]/common[common.length-2]);
        return answer;
    }
}