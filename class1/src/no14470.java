import java.io.*;
import java.util.StringTokenizer;

/**
 * 1. A -> B가 되기위한 시간을 구해야 한다.
 * 2. 0도 미만 = 얼어있다.
 * 3. 0도 = 얼었을 수도, 안 얼었을 수도 있다.
 * 4. 0도 초과 = 녹았다.
 * 5. 얼었을 때 : C초당 1도씩 상승
 * 6. 0도이나 해동할 때 : D초 걸림
 * 7. 녹았을 때 : E초씩 오른다.
 */
public class no14470 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int A, B, C, D, E;
    public static void main(String[] args) throws IOException {

        A = Integer.parseInt(br.readLine()); // start
        B = Integer.parseInt(br.readLine()); // goal
        C = Integer.parseInt(br.readLine()); // -
        D = Integer.parseInt(br.readLine()); // 0
        E = Integer.parseInt(br.readLine()); // +
        int cnt = 0;
        boolean check = false;

        while(A!=B) {
            if(A<0) cnt += C;
            else if (A==0 && !check) {
                cnt += D;
                check = true;
                continue;
            }
            else cnt += E;
            A++;
        }
        System.out.println(cnt);
    }
}

