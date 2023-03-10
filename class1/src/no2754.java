import java.io.*;

public class no2754 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String T = br.readLine();

        if(T.equals("A+")) System.out.println(4.3);
        else if(T.equals("A0")) System.out.println(4.0);
        else if(T.equals("A-")) System.out.println(3.7);
        else if(T.equals("B+")) System.out.println(3.3);
        else if(T.equals("B0")) System.out.println(3.0);
        else if(T.equals("B-")) System.out.println(2.7);
        else if(T.equals("C+")) System.out.println(2.3);
        else if(T.equals("C0")) System.out.println(2.0);
        else if(T.equals("C-")) System.out.println(1.7);
        else if(T.equals("D+")) System.out.println(1.3);
        else if(T.equals("D0")) System.out.println(1.0);
        else if(T.equals("D-")) System.out.println(0.7);
        else System.out.println(0.0);
    }
}

