class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int[] head = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] tail = {0,0};
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    if(i<=head[0]) head[0] = i;
                    if(i>=tail[0]) tail[0] = i+1;
                    if(j<=head[1]) head[1] = j;
                    if(j>=tail[1]) tail[1] = j+1;
                }
            }
        }

        answer[0] = head[0];
        answer[1] = head[1];
        answer[2] = tail[0];
        answer[3] = tail[1];
        return answer;
    }
}