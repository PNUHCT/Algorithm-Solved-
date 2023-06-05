import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	final static long MOD = 1000000007;
	private static long[][] origin = {{1, 1} , {1, 0}};	// 초기값을 갖고있는 행렬
	
	public static void main(String[] args) throws IOException{		
		long[][] A = {{1, 1} , {1, 0}};	
		long N = Long.parseLong(br.readLine());
		
		System.out.println(pow(A, N - 1)[0][0]);
	}
	
	// 행렬 제곱 분할정복 메소드
	public static long[][] pow(long[][] A, long exp) {
 
		// 지수가 1 또는 0일 땐 A를 return한다.
		if(exp == 1 || exp == 0) return A;
		
		// 지수를 절반으로 분할하여 재귀호출
		long[][] ret = pow(A, exp / 2);
		
		// 하위 재귀에서 얻은 행렬을 제곱해준다.
		ret = multiply(ret, ret);
		
		// 만약 지수가 홀수라면 마지막에  A^1 (origin)을 곱해준다.
		if(exp % 2 == 1L) ret = multiply(ret, origin);
		
		return ret;
	}
	
	
	// o1과 o2 행렬을 곱해주는 메소드
	public static long[][] multiply(long[][] o1, long[][] o2) {
		
		long[][] ret = new long[2][2];
 
		ret[0][0] = ((o1[0][0] * o2[0][0]) + (o1[0][1] * o2[1][0])) % MOD;
		ret[0][1] = ((o1[0][0] * o2[0][1]) + (o1[0][1] * o2[1][1])) % MOD;
		ret[1][0] = ((o1[1][0] * o2[0][0]) + (o1[1][1] * o2[1][0])) % MOD;
		ret[1][1] = ((o1[1][0] * o2[0][1]) + (o1[1][1] * o2[1][1])) % MOD;

		return ret;
	}
 
}