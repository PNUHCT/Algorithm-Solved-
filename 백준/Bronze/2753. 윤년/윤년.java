import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        if (T%400==0) bw.write(""+1+"\n");
        else if(T%4==0 && T%100!=0) bw.write(""+1+ "\n");
        else bw.write(""+0+ "\n");

        bw.close();
    }
}