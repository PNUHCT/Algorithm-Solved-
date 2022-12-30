import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int title = 666;
        int count = 1;
        while(count != T) {
            title++;
            if(String.valueOf(title).contains("666")) count++;
        }
        System.out.println(title);
    }
}

