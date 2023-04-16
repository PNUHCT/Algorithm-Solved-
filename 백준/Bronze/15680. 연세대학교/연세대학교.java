import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        if(N.equals("0")) System.out.println("YONSEI");
        else System.out.println("Leading the Way to the Future");
    }
}