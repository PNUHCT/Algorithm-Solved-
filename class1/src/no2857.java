import java.io.*;
import java.util.StringTokenizer;

public class no2857 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        for(int i=1 ; i<=5 ; i++) if(br.readLine().contains("FBI")) result.append(i).append(" ");

        if(result.length()!=0) System.out.println(result);
        else System.out.println("HE GOT AWAY!");
    }
}

