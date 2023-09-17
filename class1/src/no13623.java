import java.io.*;
import java.util.*;

public class no13623 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String A, B ,C;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String[] arr = new String[3];

        for(int i=0; i<3 ; i++) arr[i] = st.nextToken();

        int One = 0;
        int Zero = 0;

        for(int i=0 ; i<3 ; i++) {
            if(arr[i].equals("1")) One++;
            else Zero++;
        }

        if(One==-0 || Zero == 0) { System.out.println("*"); }
        else if (One>Zero) { for(int i=0 ; i<3 ; i++) if(arr[i].equals("0")) System.out.println((char) (65 + i)); }
        else { for(int i=0 ; i<3 ; i++) if(arr[i].equals("1")) System.out.println((char) (65 + i)); }
    }
}