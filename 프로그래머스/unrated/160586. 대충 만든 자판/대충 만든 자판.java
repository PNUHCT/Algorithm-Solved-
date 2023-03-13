class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int targetCount = 0;
            for(int j = 0; j < target.length(); j++) {
                int count = Integer.MAX_VALUE;
                for(int k = 0; k < keymap.length; k++) {
                    String key = keymap[k];
                    for(int l = 0; l < key.length(); l++) {
                        if(target.charAt(j)==key.charAt(l) && l <= count)count = l;
                    }
                }
                if(count==Integer.MAX_VALUE) {
                    targetCount = -1;
                    break;
                }
                else targetCount += count+1;
            }
            answer[i] = targetCount;
        }

        return answer;
    }
}