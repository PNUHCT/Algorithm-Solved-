import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken()); // 열
        int col = Integer.parseInt(st.nextToken()); // 행

        String[] board = new String[row];
        for(int i = 0; i < row; i++) board[i] = (br.readLine());

        int min = Integer.MAX_VALUE; // 최소값 찾기 위한 최대값

        // 시작 칸이 될 수 있는 범위까지의 for문
        for(int i = 0; i <= row - 8; i++) {
            for(int j = 0; j <= col - 8; j++) {
                int sol = solved(i, j, board);
                if(min > sol) min = sol;
            }
        }
        System.out.println(min);
    }

    // 8 * 8
    private static int solved(int startRow, int startCol, String[] board) {
        String[] stanBoard = {"BWBWBWBW", "WBWBWBWB"}; // 기준
        int sol = 0;

        // 각 칸마다 비교하는 for문
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(board[startRow + i].charAt(startCol + j)
                        != stanBoard[(startRow + i) % 2].charAt(j)) sol++;
            }
        }

        // 최대 경우의 수 : 64
        // 첫 색을 기준으로 센 수, 첫 색의 반대를 기준으로 센 수
        return Math.min(sol, 64 - sol);
    }
}