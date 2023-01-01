import java.io.*;
import java.util.StringTokenizer;

public class no2609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int GDC = gdc(A, B);

        bw.write("" + GDC + "\n");

        int LCM = lcm(A, B);
        bw.write("" + LCM + "\n");

        bw.close();
    }

    // 유클리드 호제법 (최대공약수)
    private static int gdc(int A, int B) {
        if(A<B) {
            int temp = A;
            A = B;
            B = temp;
        }
        while(B!=0) {
            int R = A%B;
            A=B;
            B=R;
        }
        return A;
    }

    // 유클리드 호제법 (최소공배수)
    private static int lcm(int A, int B) {
        return A * B / gdc(A,B);
    }
}

