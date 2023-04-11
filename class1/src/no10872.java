import java.io.*;
public class no10872 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int result = 1;
        while(T>0) {
            result *= T;
            T--;
        }
        System.out.println(result);
    }
}

