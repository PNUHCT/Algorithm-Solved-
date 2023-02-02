package Softeer;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class AB {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=1; i<=T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Integer A = Integer.parseInt(st.nextToken());
            Integer B = Integer.parseInt(st.nextToken());
            System.out.println(String.format("Case #%d: %d",i,A+B));
        }
    }
}

