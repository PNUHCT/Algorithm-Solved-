import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String code = br.readLine().replace(" ","");
        if (code.equals("12345678")) System.out.println("ascending");
        else if (code.equals("87654321")) System.out.println("descending");
        else System.out.println("mixed");
        
    }
}