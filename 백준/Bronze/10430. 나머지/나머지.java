import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Long A = Long.valueOf(st.nextToken());
        Long B = Long.valueOf(st.nextToken());
        Long C = Long.valueOf(st.nextToken());

        bw.write(""+(A+B)%C+"\n");
        bw.write(""+((A%C)+(B%C))%C+"\n");
        bw.write(""+(A*B)%C+"\n");
        bw.write(""+((A%C)*(B%C))%C+"\n");

        bw.close();
    }
}

