import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class no1076 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int T;

    private static String[][] input_table =
                    {{"black", "0", "1"},
                    {"brown", "1", "10"},
                    {"red", "2", "100"},
                    {"orange", "3", "1000"},
                    {"yellow", "4", "10000"},
                    {"green", "5", "100000"},
                    {"blue", "6", "1000000"},
                    {"violet", "7", "10000000"},
                    {"grey", "8", "100000000"},
                    {"white", "9", "1000000000"}};

    private static Map<String, String[]> data = new HashMap<>();
    public static void main(String[] args) throws IOException {
        for(String[] arr : input_table) {
            data.put(arr[0], new String[]{arr[1], arr[2]});
        }

        String head = data.get(br.readLine())[0] + data.get(br.readLine())[0];
        BigInteger result =
                new BigInteger(head).multiply(new BigInteger(data.get(br.readLine())[1]));

        System.out.println(result);
    }
}