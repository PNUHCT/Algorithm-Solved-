import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class no1629 {

    // 단순 계산법 - 메모리 초과
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        BigInteger A = new BigInteger(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        BigInteger C = new BigInteger(st.nextToken());
        BigInteger mod = new BigInteger("2147483647");
        BigInteger result = new BigInteger("1");


        while(B-->1) {
            BigInteger now = result.multiply(A);
            if(now.compareTo(mod)==-1) {
                result = now;
            } else {
                result = now.mod(C);
            }
        }
        System.out.println(result);
    }

    //
}

