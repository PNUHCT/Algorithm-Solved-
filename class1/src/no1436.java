import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Integer title = 666;
        int count = 1;
        while (count != T) {
            title++;
            if (String.valueOf(title).contains("5666")) {
                String temp = title.toString();
                temp.replace("5666", "6660");
                title = Integer.valueOf(temp);
                count++;
            } else if (String.valueOf(title).contains("6669")) {
                String temp = title.toString();
                temp.replace("6669", "7666");
                title = Integer.valueOf(temp);
                count++;
            } else if (String.valueOf(title).contains("666")) {
                count++;
            }
        }
        System.out.println(title);
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//        Integer title = 666;
//        int count = 1;
//        while (count != T) {
//            title++;
//
//            if (String.valueOf(title).contains("666")) count++;
//        }
//        System.out.println(title);
//    }

}