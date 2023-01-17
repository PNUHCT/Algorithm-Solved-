import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        long result;
        int cnt = T-1;
        result = calculate(arr, cnt, arr[cnt]-96);

        System.out.println(result);
    }
    private static long calculate(char[] arr, int cnt, long result) {
        if(cnt<=0) return result;
        result = (arr[cnt-1]-96) + (31 * result);
        cnt--;
        return calculate(arr, cnt, result);
    }
}
