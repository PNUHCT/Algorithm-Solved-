import java.io.*;

public class Main {
    /**
     * 브루트 포스
     * 1. 1부터 제곱
     * 2. 제곱이 N보다 크면, 다음 차례로 넘어감
     * 3. 1부터 제곱 + 1부터 제곱 의 반복
     * 4. 합이 N보다 크면, 다음 차례로 넘어감
     * 5. 이런식으로 총 4개까지 진행
     * 6. 중간에 같은 수가 나오면, 제곱을 위해 더한 개수를 출력
     */

    private static double N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        System.out.println(brute());
    }

    private static int brute () {
        int result = 4;
        int sqrtN = (int) Math.sqrt(N);

        for(int i = 0; i <= sqrtN; i++) {
            for(int j = 0; j <= sqrtN; j++) {
                for(int k = 0; k <= sqrtN; k++) {
                    double sum = Math.pow(k, 2) + Math.pow(j, 2) + Math.pow(i, 2);
                    if(sum==N) {
                        if(i!=0) return 3;
                        else if (j!=0) return 2;
                        else return 1;
                    }
                }
            }
        }

        return result;
    }
}