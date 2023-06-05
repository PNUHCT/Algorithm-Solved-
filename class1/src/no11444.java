import java.io.*;
import java.math.BigInteger;

/**
 * 재귀를 이용한 계산방식
 */
public class no11444 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BigInteger mod = new BigInteger("1000000007");
    private static BigInteger[][] base = {{new BigInteger("1"), new BigInteger("1")},
                                            {new BigInteger("1"), new BigInteger("0")}};

    public static void main(String[] args) throws Exception {
        BigInteger N = new BigInteger(br.readLine());

        /** 공식이 될 행렬
         *        |1   1|     |F(n+1)  F(n)|
         * A^n =  |     |  =  |            |
         *        |1   0|     |F(n)  F(n-1)|
         */

        BigInteger[][] A = {{new BigInteger("1"), new BigInteger("1")},
                            {new BigInteger("1"), new BigInteger("0")}};

        System.out.println(pow(A, N.subtract(new BigInteger("1")))[0][0]);
    }

    private static BigInteger[][] pow(BigInteger[][] A, BigInteger exp) {
        if(exp.equals(new BigInteger("1")) || exp.equals(new BigInteger("0"))) return A; // 지수가 1 또는 O인 경우

        BigInteger[][] ret = pow(A, exp.divide(new BigInteger("2"))); // 지수를 절반으로 분할하여 재귀 호출

        ret = multiply(ret,ret);

        if(exp.mod(new BigInteger("2")).equals(new BigInteger("1"))) ret = multiply(ret, base);

        return ret;
    }

    private static BigInteger[][] multiply(BigInteger[][] o1, BigInteger[][] o2) {
        BigInteger[][] ret = new BigInteger[2][2];

        ret[0][0] = ((o1[0][0]).multiply(o2[0][0])).add((o1[0][1].multiply(o2[1][0]))).mod(mod);
        ret[0][1] = ((o1[0][0]).multiply(o2[0][1])).add((o1[0][1].multiply(o2[1][1]))).mod(mod);
        ret[1][0] = ((o1[1][0]).multiply(o2[0][0])).add((o1[1][1].multiply(o2[1][0]))).mod(mod);
        ret[1][1] = ((o1[1][0]).multiply(o2[0][1])).add((o1[1][1].multiply(o2[1][1]))).mod(mod);

        return ret;
    }
}

