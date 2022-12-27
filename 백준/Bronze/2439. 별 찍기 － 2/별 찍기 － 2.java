import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String[][] matrix = new String[T+1][T];

        for(int i=1; i<=T; i++) {

            for(int j=0; j<T-i; j++) {
                matrix[i][j] = " ";
            }

            for(int j=1; j<=i; j++) {
                matrix[i][T-j] = "*";
            }

            String S = "";
            for(int j=0; j<T; j++) {
                S += matrix[i][j];
            }
            bw.write(S+"\n");

        }
        bw.close();
    }

}

