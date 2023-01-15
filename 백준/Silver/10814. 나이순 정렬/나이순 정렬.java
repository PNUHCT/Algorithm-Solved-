import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        String[][] matrix = new String[T][2];

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            matrix[i][0] = st.nextToken();
            matrix[i][1] = st.nextToken();
        }
        Arrays.sort(matrix, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(Integer.parseInt(o1[1]), Integer.parseInt(o2[1]));
            } else {
                return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
            }
        });

        for(int i = 0;i<T;i++) {
            bw.write(matrix[i][0]+" "+matrix[i][1]+"\n");
        }

        bw.close();
    }
}