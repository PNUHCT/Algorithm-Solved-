import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class no11403 {
    static int T;
    static Integer[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 맵 구성
        T = Integer.parseInt(br.readLine());
        matrix= new Integer[T][T];
        for(int i=0; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<T ; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int y=0; y<T ; y++) {
            for(int x=0; x<T ;x++) {
                for (int z=0; z<T ; z++) {
                    if(matrix[x][y].equals(1) && matrix[y][z].equals(1)) {
                        matrix[x][z] = 1;
                    }
                }
            }
        }

        for (int i=0; i<T ; i++) {
            for (int j=0; j<T ; j++) {
                bw.write(""+matrix[i][j]+ " ");
                if(j==T-1) bw.append("\n");
            }
        }

        bw.close();
    }
}

