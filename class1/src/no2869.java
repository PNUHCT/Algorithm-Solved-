import java.io.*;
import java.util.StringTokenizer;

public class no2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Integer A = Integer.parseInt(st.nextToken());
        Integer B = Integer.parseInt(st.nextToken());
        Integer V = Integer.parseInt(st.nextToken());

        int caseA = ((V - A) / (A - B)) + 1;
        int caseB = ((V - A) / (A - B)) + 2;
        int result = (A - B == 1) ? caseA : ((V - A)%(A - B)==0) ? caseA : caseB;

        System.out.println(result);
    }
}
