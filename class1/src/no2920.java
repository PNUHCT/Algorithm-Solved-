import java.io.*;
import java.util.StringTokenizer;

public class no2920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String code = br.readLine().replace(" ","");

        /* 1. BufferedWriter 사용시 = 14132KB | 132ms */
//        if (code.equals("12345678")) bw.write("ascending");
//        else if (code.equals("87654321")) bw.write("descending");
//        else bw.write("mixed");
//
//        bw.close();

        /* 2. System.out.println() 사용시 = 14080KB | 124ms */
        if (code.equals("12345678")) System.out.println("ascending");
        else if (code.equals("87654321")) System.out.println("descending");
        else System.out.println("mixed");

    }
}

