import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no2292 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 벌집 중앙값 = 시작값 = 첫줄의 맨 마지막 수 = tail
         * 원리 :
         * 1. 벌집의 육각 모양에서 유추 -> 벌집은 +1외각으로 갈 때마다 둘러싸는 숫자의 개수가 6의 배수로 증가한다.
         * 2. 외각의 첫 수는 직전 각의 마지막 수(tail) +1 이다
         * 3. 외각의 마지막 수는 현재 각의 첫 수(head) + (현재각의 순서(몇 번째 각인지)*6 -1)이다.
         * 4. 주어진 수가 현재각의 첫 수~마지막수 사이에 있을 때까지 반복
         * 5. 1부터 주어진 수까지 가는 직선거리는 주어진 수가 있는 각 수 +1이다
         */
        int n = Integer.parseInt(br.readLine());
        int head;
        int tail = 1; // 벌집 중앙값
        int k = 1;

        while (true) {
            head = tail + 1;  // 현재 각의 맨 첫번째 수
            tail = head + ((k * 6) - 1); // 현재 각의 맨 마지막 수

            if (head <= n && tail >= n) break;  // 현재 각에 포함되면 스답
            k++; // 현재 각 안에 없는 경우, 다음 각으로 이동
        }
        if (n == 1) System.out.println(1);
        else System.out.println(k + 1); // 1이 있는 0번째부터 현재각까지의 거리 출력
    }
}

