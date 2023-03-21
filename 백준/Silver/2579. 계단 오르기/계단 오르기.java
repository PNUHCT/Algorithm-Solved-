import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] map = new int[T+1];
        for(int i=1; i<=T; i++) map[i] = Integer.parseInt(br.readLine());

        int[] DP = new int[T+1]; // i번째 까지의 합을 기록할 배열
        DP[1] = map[1]; // DP로 기록할 배열 초기화 과정
        if(T>=2) DP[2] = map[1] + map[2]; // 주어진 입력이 2개 이상일 경우. DP에서 연속된 3계단을 판단하기 위해선 기본 3칸은 필요(0,1,2)

        for(int now=3 ; now<=T ; now++) {
            DP[now] = Math.max(DP[now-2], DP[now-3] + map[now-1]) // 현재 칸 전에 있는 세 칸중, 첫번째칸+세번째칸 값이 두번째 값 칸보다 커야지 연속될 가치가 있는 것
                    + map[now]; // 현재 칸의 값을 합쳐줌
        }

        System.out.println(DP[T]); // 최대값이 저장 된 마지막칸을 출력
    }
}