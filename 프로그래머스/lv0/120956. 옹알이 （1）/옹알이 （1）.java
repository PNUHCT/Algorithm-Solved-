class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] arr = {"aya", "ye", "woo", "ma"};

        for(int j =0;j<babbling.length ; j++) {
            String temp = babbling[j];
            for (int i = 0; i < 4; i++) if (temp.contains(arr[i])) temp = temp.replace(arr[i], "#");
            String compare = "";
            for (int i = 0; i < temp.length(); i++) compare += "#";
            if(temp.equals(compare)) answer++;
        }

        return answer;
    }
}