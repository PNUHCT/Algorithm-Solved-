import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Integer A = Integer.parseInt(st.nextToken());
        Integer B = Integer.parseInt(st.nextToken());
        Integer V = Integer.parseInt(st.nextToken());
//        int result = (A - B == 1) ? ((V - A) / (A - B)) + 1 : ((V - A) % (A - B)) + 1;
        int result = 0;
        if(A - B == 1) {
            result = ((V - A) / (A - B)) + 1;
        } else {
            if((V - A)%(A - B)==0) {
                result = ((V - A) / (A - B)) + 1;
            } else {
                result = ((V - A) / (A - B)) + 2;
            }
        }

        System.out.println(result);
    }
}
