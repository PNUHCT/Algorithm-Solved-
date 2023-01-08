import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = fact(N)/(fact(K)*fact(N-K));
        System.out.println(result);
    }

    private static int fact(int n) {
        int p = 1;
        for(int i=1 ; i<=n ; i++) {p = p*i;}
        return p;
    }
}

