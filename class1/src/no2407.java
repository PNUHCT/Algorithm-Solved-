import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class no2407 {

    /**
     * nCm = n! / (m! * (n-m)!)
     * 숫자 메모리 범위를 염두하여 int 대신 BigInteger 사용
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());

        BigInteger result = factorial(n).divide((factorial(m).multiply(factorial(n.subtract(m)))));
        System.out.println(result);
    }

    /**
     * 팩토리얼 계산
     * 입력된 숫자가 1보다 작거나 같을 때 1리턴: 즉, 1이 될 때까지 -1
     * 순차적으로 반환되면서 직전의 a값을 곱해줌.
     *
     * 예시 : 처음 a가 3일때, 괄호는 factorial 계산의 반환값
     * a=1 일 때, 1
     * a=2 일 때, (1) * 2
     * a=3 일 때. (1 * 2) * 3
     * 즉,
     * ((1) * 2) * 3
     * = 1 * 2 * 3
     */
    private static BigInteger factorial(BigInteger a) {
        if(a.compareTo(BigInteger.valueOf(1))<=0) return a;
        else return factorial(a.subtract(BigInteger.valueOf(1))).multiply(a);
    }
}

