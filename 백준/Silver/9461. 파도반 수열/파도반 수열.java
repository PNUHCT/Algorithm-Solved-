import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static Long[] arr = new Long[101]; // 최대 N은 100이므로

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr[0] = 0L;
        arr[1] = 1L;
        arr[2] = 1L;
        arr[3] = 1L;
        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            bw.write(""+padovan(Integer.parseInt(br.readLine()))+"\n");
        }
        bw.close();
    }

    private static Long padovan(int N) {
        if(arr[N] == null) arr[N] = padovan(N-2) + padovan(N-3);
        return arr[N];
    }
}