import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class no5532 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine()); // 방학일수
        int A = Integer.parseInt(br.readLine()); // 국어 총 페이지 수
        int B = Integer.parseInt(br.readLine()); // 수학 총 페이지 수
        int C = Integer.parseInt(br.readLine()); // 하루 최대 국어 페이지 수
        int D = Integer.parseInt(br.readLine()); // 하루 최대 수학 페이지 수

        int math;
        if(B%D == 0) math = B/D;
        else math = B/D+1;

        int language;
        if(A%C == 0) language = A/C;
        else language = A/C+1;

        int min;
        if(math>=language) min = math;
        else min = language;

        System.out.println(L-min);
    }
}

