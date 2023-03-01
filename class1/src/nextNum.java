import java.io.*;

public class nextNum {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] common = {1, 2, 3, 4};
        int result = solution(common);
        System.out.println(result);

        common = new int[]{2, 4, 8};
        result = solution(common);
        System.out.println(result);
    }

    public static int solution(int[] common) {
        // 등차수열인지 확인 -> 아니면 등비수열
        int answer = 0;
        if((common[0]-common[1])==(common[1]-common[2])) {
            answer = common[common.length-1] + (common[common.length-1] - common[common.length-2]);
        }
        else answer = common[common.length-1] * (common[common.length-1]/common[common.length-2]);
        return answer;
    }
}
