import java.io.*;
import java.util.StringTokenizer;

public class no14489 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int price, Balance;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Balance = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        price = Integer.parseInt(br.readLine()) * 2;

        if(Balance>=price) System.out.println(Balance-price);
        else System.out.println(Balance);
    }
}

