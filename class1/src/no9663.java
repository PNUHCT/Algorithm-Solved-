import java.io.*;

public class no9663 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, count;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        check(0); // check의 int형 변수 = 0~N번째으 퀸

        System.out.println(count);
    }

    private static void check(int nQueen) {
        // N개를 채운 상태면 count 증가 후 스답
        if(nQueen == N) {
            count++;
            return;
        }

        for(int i = 0 ; i < N ; i++) { // N개까지 확인할 것이며,
            arr[nQueen] = i;
            if(possibility(nQueen)) check(nQueen + 1); // N개 중 현재 순서의 퀸을 놓을 수 있다면, 다음 퀀 놓을자리를 다시 체크
        }
    }

    /**
     * 상하좌우 방향의 모든 칸에 대해서 가능/불가능 확인 용도의 메소드
     */
    private static boolean possibility(int column) {
        for(int now = 0 ; now < column ; now++) {
            if(arr[column] == arr[now]) return false;
            else if (Math.abs(column - now) == Math.abs(arr[column] - arr[now])) return false;
        }
        return  true;
    }
}
