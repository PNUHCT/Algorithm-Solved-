import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * DP with sliding window method
 */
public class no2096 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] maxDP = new int[3];
        int[] minDP = new int[3];
        StringTokenizer st;

        OUTER : for(int i=0 ; i<N ; i++) {
            st = new StringTokenizer(br.readLine()," ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            // 첫 번째 줄은 무조건 들어가야함
            if(i==0) {
                maxDP[0] = minDP[0] = A;
                maxDP[1] = minDP[1] = B;
                maxDP[2] = minDP[2] = C;
                continue OUTER;
            }

            /**
             * 원리
             * 1. maxDP에는 항상 합산의 최대값들로 저장 && minDP에는 항상 합산의 최소값들로 저장되도록 할 것이다.
             * 2. 따라서 새 줄을 입력받을 때, 이전 최대값 중 양쪽 끝값을 임시 저장한다.
             * 3. 0번째는 결국 이전 0번째와 1번째 중 하나와 현재 값의 합산이 될 것이다.
             * 4. 2번째는 결국 이전 1번째와 2번째 중 하나와 현재 값의 합산이 될 것이다.
             * 5. 1번째는 결국 이전 0번째와 1번째를 비교한 뒤 -> 둘중 더 큰(작은)값과 2번째 값을 비교해서 큰(작은)값이 들어간다.
             * 6. 이 과정을 N번쨰 줄까지 반복한다.
             */

            // max값 구하기
            int beforeMax_0 = maxDP[0];
            int beforeMax_2 = maxDP[2];
            maxDP[0] = Math.max(beforeMax_0, maxDP[1]) + A;
            maxDP[2] = Math.max(beforeMax_2, maxDP[1]) + C;
            maxDP[1] = Math.max(Math.max(beforeMax_0, maxDP[1]), beforeMax_2) + B;

            // min값 구하기
            int beforeMin_0 = minDP[0];
            int beforeMin_2 = minDP[2];
            minDP[0] = Math.min(beforeMin_0, minDP[1]) + A;
            minDP[2] = Math.min(beforeMin_2, minDP[1]) + C;
            minDP[1] = Math.min(Math.min(beforeMin_0, minDP[1]), beforeMin_2) + B;
        }
        bw.write("" + Math.max(Math.max(maxDP[0],maxDP[1]), maxDP[2]) + " ");
        bw.write(""+ Math.min(Math.min(minDP[0],minDP[1]), minDP[2]));

        bw.close();
    }
}