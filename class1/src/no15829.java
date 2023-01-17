import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no15829 {
    /**
     * Math.pow() 없이 하는 방법 중
     * moduler M을 적용한 코드
     * 만약 mod(M)을 적용하지 않으면 overflow가 발생한다
     * 사실상 31%M이나, 31이나 같다는 점을 이용한다. (분배법칙)
     */
    private static final int M = 1234567891;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        long r = 1;
        long result = 0;

        String str = br.readLine();

        for (int i = 0 ; i < str.length() ; i++) {
            result += (str.charAt(i) - 96) * r % M;
            r =  r * 31 % M;
            // r *= 31 % M; 이렇게하면 r * r 부터 적용되어 overflow 발생한다.
        }
        result = result % M;
        System.out.println(result);
    }
}

