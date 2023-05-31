import java.util.*;
import java.io.*;

public class no9251 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String first, second;
    private static Integer[][] DP; // null값으로 체크하기 위해 int가 아닌 Integer사용

    public static void main(String[] args) throws IOException {
        first = br.readLine();
        second = br.readLine();
        
        DP = new Integer[first.length()][second.length()];

        int LCS = recur(first.length()-1, second.length()-1);

        System.out.println(LCS);
    }    

    /**
     * 
     * @param y : DP[][]의 Y축
     * @param x : DP[][]의 X축
     * @return
     */
    private static int recur (int y, int x) {

        // 만약 음수가 되는 경우(2차원 배열의 범위를 벗어나는 경우) => 누계를 위해 0을 리턴
        if(y<0 || x<0) return 0;
        
        if(DP[y][x]==null) { // 해당 칸에 처음 방문하는 경우
            DP[y][x] = 0; // 우선 0으로 초기화
            if(first.charAt(y) == second.charAt(x)) { // 만약 현재 선택한 두 수열에서의 문자가 같은 경우
                DP[y][x] = recur(y-1, x-1) + 1; // 직전에 구한 최대치에 +1 해라
            }
            else { // 비교하는 두 문자가 다른 경우
                DP[y][x] = recur(y-1, x) >= recur(y, x-1) ? recur(y-1, x) : recur(y, x-1); // 더 최대값인 경우를 입력
            }
        }
        return DP[y][x]; // 최종적으로 구해진 최대값은 이차원 배열 DP의 맨 마지막자리에 입력된 수
    }
}