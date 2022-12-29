import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String code = br.readLine().replace(" ","");
        if (code.equals("12345678")) bw.write("ascending");
        else if (code.equals("87654321")) bw.write("descending");
        else bw.write("mixed");

        bw.close(); 
    }
}